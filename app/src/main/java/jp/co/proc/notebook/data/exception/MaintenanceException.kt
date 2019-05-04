package jp.co.proc.notebook.data.exception

import jp.co.proc.notebook.domain.dto.ApiError
import retrofit2.HttpException
import retrofit2.Response

/**
 * メンテンナス中エラー例外クラス
 *
 * HttpExceptionをラップし、HTTPステータスコードが503の場合にthrowされる
 */
class MaintenanceException(response: Response<*>, private val apiError: ApiError) : HttpException(response) {

    /**
     * APIエラー時にサーバーから返却されるcode
     */
    val code: String
        get() = apiError.code
}
