package jp.co.proc.notebook.domain.exception

/**
 * エラーバンドル
 *
 * Created by kharada on 2017/08/01.
 */
class DefaultErrorBundle(override val exception: Exception) : ErrorBundle {

    override val errorMessage: String
        get() = this.exception.message ?: "Unknown error"
}
