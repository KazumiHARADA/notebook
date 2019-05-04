package jp.co.proc.notebook.data.exception

import jp.co.proc.notebook.domain.dto.ApiError
import retrofit2.HttpException
import retrofit2.Response

/**
 * 認証例外クラス
 *
 * サーバーから返却されたjsonを保持する
 */
class AuthException(response: Response<*>, private val apiError: ApiError) : HttpException(response) {

    /**
     * APIエラー時にサーバーから返却されるcode
     */
    val code: String
        get() = apiError.code

}