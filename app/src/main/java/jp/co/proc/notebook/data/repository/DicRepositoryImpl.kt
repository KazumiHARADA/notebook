package jp.co.proc.notebook.data.repository

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import io.reactivex.Single
import jp.co.proc.notebook.data.api.DicApiClient
import jp.co.proc.notebook.data.entity.WordEntity
import jp.co.proc.notebook.data.mapper.WordEntityDtoMapper
import jp.co.proc.notebook.data.util.DictionaryDatabaseOpenHelper
import jp.co.proc.notebook.domain.dto.Word
import jp.co.proc.notebook.domain.repository.DicRepository
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-02.
 */
class DicRepositoryImpl @Inject
internal constructor(
    private val dicApiClient: DicApiClient,
    private val wordEntityDtoMapper: WordEntityDtoMapper,
    private val dictionaryDatabaseOpenHelper: DictionaryDatabaseOpenHelper
) : DicRepository {

    override fun allSuggestWords(): Single<List<Word>> {
        return Single.create { emitter ->
            try {
                val result: ArrayList<WordEntity> = ArrayList()
                val db: SQLiteDatabase = dictionaryDatabaseOpenHelper.readableDatabase
                val cursor: Cursor = db.rawQuery("select * from items", arrayOf())
                cursor.use {
                    while (cursor.moveToNext()) {
                        val wordEntity = WordEntity()
                        wordEntity.item_id = cursor.getString(cursor.getColumnIndex("item_id"))
                        wordEntity.word = cursor.getString(cursor.getColumnIndex("word"))
                        wordEntity.mean = cursor.getString(cursor.getColumnIndex("mean"))
                        result.add(wordEntity)
                    }
                }
                emitter.onSuccess(result.map { wordEntityDtoMapper.transform(it) })
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }

    override fun searchSuggestWords(inputText: String): Single<List<Word>> {
        return Single.create { emitter ->
            try {
                val result: ArrayList<WordEntity> = ArrayList()
                val db: SQLiteDatabase = dictionaryDatabaseOpenHelper.readableDatabase
                val cursor: Cursor = db.rawQuery("select * from items where word like ?", arrayOf("$inputText%"))
                cursor.use {
                    while (cursor.moveToNext()) {
                        val wordEntity = WordEntity()
                        wordEntity.item_id = cursor.getString(cursor.getColumnIndex("item_id"))
                        wordEntity.word = cursor.getString(cursor.getColumnIndex("word"))
                        wordEntity.mean = cursor.getString(cursor.getColumnIndex("mean"))
                        result.add(wordEntity)
                    }
                }
                emitter.onSuccess(result.map { wordEntityDtoMapper.transform(it) })
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }
}