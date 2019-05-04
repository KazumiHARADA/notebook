package jp.co.proc.notebook.domain.exception

/**
 * エラーバンドルのインターフェース
 *
 * Created by kharada on 2017/08/01.
 */
interface ErrorBundle {
    val exception: Exception

    val errorMessage: String
}
