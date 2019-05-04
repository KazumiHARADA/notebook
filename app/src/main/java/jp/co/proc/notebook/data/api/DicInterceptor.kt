package jp.co.proc.notebook.data.api

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.nio.charset.Charset


/**
 * Created by kharada on 2019-05-02.
 */
class DicInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (response.code() == 200) {
            val path: String = request.url().url().path
            when {
                path.contains("SearchDicItemLite") -> {
                    val source = response.body()?.source()
                    source?.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
                    val buffer = source?.buffer()
                    val responseBodyString = buffer?.clone()?.readString(Charset.forName("UTF-8")) ?: ""
                    val newString = responseBodyString.replace(" class=\"NetDicTitle\" xmlns=\"\"", "")
                    val responseBody = ResponseBody.create(
                        response.body()?.contentType(),
                        newString.toByteArray()
                    )
                    return response.newBuilder().body(responseBody).build()
                }
                path.contains("GetDicItemLite") -> {
                    val source = response.body()?.source()
                    source?.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
                    val buffer = source?.buffer()
                    val responseBodyString = buffer?.clone()?.readString(Charset.forName("UTF-8")) ?: ""
                    val newString = responseBodyString
                        .replace(" class=\"NetDicHead\" xml:space=\"preserve\" xmlns=\"\"", "")
                        .replace(" class=\"NetDicHeadTitle\"", "")
                        .replace(" class=\"NetDicBody\" xml:space=\"preserve\" xmlns=\"\"", "")
                    val responseBody = ResponseBody.create(
                        response.body()?.contentType(),
                        newString.toByteArray()
                    )
                    return response.newBuilder().body(responseBody).build()
                }
            }

        }
        return response;
    }

}