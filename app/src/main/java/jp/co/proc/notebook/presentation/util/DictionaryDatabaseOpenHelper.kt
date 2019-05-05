package jp.co.proc.notebook.presentation.util

import android.content.Context
import android.content.res.AssetManager
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


/**
 * Created by kharada on 2019-05-05.
 */
class DictionaryDatabaseOpenHelper
constructor(
    context: Context
) : SQLiteOpenHelper(context,
    DB_NAME, null,
    DATABASE_VERSION
) {

    companion object {
        const val DB_NAME = "dic_database"
        const val DATABASE_VERSION = 1
        const val ASSET_FILE_NAME = "ejdict.sqlite3.zip"
        val TAG = DictionaryDatabaseOpenHelper::class.java.simpleName
    }

    private val mDatabasePath: File = context.getDatabasePath(DB_NAME)
    private val mContext: Context = context


    override fun onCreate(db: SQLiteDatabase?) {
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    /**
     * asset に格納したデータベースをコピーするための空のデータベースを作成する
     */
    @Throws(IOException::class)
    fun uncompressDatabase() {
        val dbExist = checkDataBaseExists()

        if (dbExist) {
            // すでにデータベースは作成されている
        } else {
            try {
                extractZipFiles(mDatabasePath.absolutePath,
                    ASSET_FILE_NAME
                )

                val dbPath = mDatabasePath.absolutePath
                var checkDb: SQLiteDatabase? = null
                try {
                    checkDb = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE)
                } catch (e: Exception) {
                }

                if (checkDb != null) {
                    checkDb.version = DATABASE_VERSION
                    checkDb.close()
                }

            } catch (e: IOException) {
                throw Error("Error copying database")
            }

        }
    }

    /**
     * 再コピーを防止するために、すでにデータベースがあるかどうか判定する
     *
     * @return 存在している場合 `true`
     */
    private fun checkDataBaseExists(): Boolean {
        val dbPath = mDatabasePath.absolutePath

        var checkDb: SQLiteDatabase? = null
        try {
            checkDb = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY)
        } catch (e: Exception) {
            // データベースはまだ存在していない
        }

        if (checkDb == null) {
            // データベースはまだ存在していない
            return false
        }

        val oldVersion = checkDb.version
        val newVersion = DATABASE_VERSION

        if (oldVersion == newVersion) {
            // データベースは存在していて最新
            checkDb.close()
            return true
        }

        // データベースが存在していて最新ではないので削除
        val f = File(dbPath)
        f.delete()
        return false
    }


    private fun extractZipFiles(dest: String, zipName: String) {
        try {
            val assetManager = mContext.assets
            val inputStream = assetManager.open(zipName, AssetManager.ACCESS_STREAMING)
            val zipInputStream = ZipInputStream(inputStream)
            var zipEntry: ZipEntry? = zipInputStream.nextEntry

            while (zipEntry != null) {
                if (zipName.contains(zipEntry.name)) {
                    var n = 0
                    val fileOutputStream = FileOutputStream(dest)

                    val buf = ByteArray(DEFAULT_BUFFER_SIZE)
                    do {
                        n = zipInputStream.read(buf, 0, DEFAULT_BUFFER_SIZE)
                        if (n == -1) {
                            break
                        } else {
                            fileOutputStream.write(buf, 0, n)
                        }
                    } while (true)
                    fileOutputStream.close()
                }
                zipInputStream.closeEntry()
                zipEntry = zipInputStream.nextEntry
            }
            zipInputStream.close()
        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
    }

    fun getSuggestWords(text : String) {
        val db : SQLiteDatabase = readableDatabase
        val cursor : Cursor = db.rawQuery("select * from items where word like ?" ,arrayOf("$text%"))
        cursor.use {
            while (cursor.moveToNext()) {
                Log.d(TAG, cursor.getString(cursor.getColumnIndex("word")))
                Log.d(TAG, cursor.getString(cursor.getColumnIndex("mean")))
            }
        }
    }


}