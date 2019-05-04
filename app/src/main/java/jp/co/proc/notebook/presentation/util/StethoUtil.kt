package jp.co.proc.notebook.presentation.util

import android.content.Context
import android.os.Build
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor

/**
 * Stetho設定（デバッグ用）
 */
class StethoUtil {

    companion object {
        val isEnabled: Boolean = true

        fun initialize(context: Context) {
            if (!isRoboUnitTest()) Stetho.initializeWithDefaults(context)
        }

        fun interceptor(): Interceptor
                = StethoInterceptor()

        private fun isRoboUnitTest() = "robolectric" == Build.FINGERPRINT
    }
}