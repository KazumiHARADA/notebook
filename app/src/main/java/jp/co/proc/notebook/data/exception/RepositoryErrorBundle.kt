package jp.co.proc.notebook.data.exception

import jp.co.proc.notebook.domain.exception.ErrorBundle


/**
 * エラーバンドル
 * エラー発生時にビューから参照する
 *
 * Created by kharada on 2017/08/01.
 */
internal class RepositoryErrorBundle(override val exception: Exception) : ErrorBundle {

    override val errorMessage: String
        get() = this.exception.message ?: ""

}
