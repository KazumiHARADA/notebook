package jp.co.proc.notebook.presentation

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.engine.executor.FifoPriorityThreadPoolExecutor
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.GlideModule
import jp.co.proc.notebook.BuildConfig
import jp.co.proc.notebook.presentation.util.StethoUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.InputStream


/**
 * Created by kharada on 2018/03/02.
 */
class StethoOkHttpGlideModule : GlideModule {

    /* Glideスレッドサイズ */
    val GLIDE_THREAD_POOL_SIZE = 25

    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
        builder?.setDiskCacheService(FifoPriorityThreadPoolExecutor(GLIDE_THREAD_POOL_SIZE))
        builder?.setResizeService(FifoPriorityThreadPoolExecutor(GLIDE_THREAD_POOL_SIZE))
    }

    override fun registerComponents(context: Context?, glide: Glide?) {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        // デバッグ用設定
        if (BuildConfig.DEBUG) {
            httpClient.addNetworkInterceptor(StethoUtil.interceptor())
            httpClient.addInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        }
        glide?.register(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(httpClient.build()))

    }
}