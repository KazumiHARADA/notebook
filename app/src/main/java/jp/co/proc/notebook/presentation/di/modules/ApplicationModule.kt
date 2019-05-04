package jp.co.proc.notebook.presentation.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import jp.co.proc.notebook.BuildConfig
import jp.co.proc.notebook.UIThread
import jp.co.proc.notebook.data.api.DicApiClient
import jp.co.proc.notebook.data.api.DicInterceptor
import jp.co.proc.notebook.data.executor.JobExecutor
import jp.co.proc.notebook.data.repository.DicRepositoryImpl
import jp.co.proc.notebook.domain.executor.PostExecutionThread
import jp.co.proc.notebook.domain.executor.ThreadExecutor
import jp.co.proc.notebook.domain.repository.DicRepository
import jp.co.proc.notebook.domain.util.Constant
import jp.co.proc.notebook.presentation.util.StethoUtil
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = this.context

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread

//    @Provides
//    @Singleton
//    fun provideMemberRepository(memberDataRepository: MemberDataRepository): MemberRepository =
//            memberDataRepository

//    @Provides
//    @Singleton
//    fun provideGoogleAnalytics() : GoogleAnalytics = GoogleAnalytics.getInstance(context)

//    @Provides
//    @Singleton
//    fun provideGAGlobalTracker() : Tracker = provideGoogleAnalytics().newTracker(R.xml.global_tracker)

    @Provides
    @Singleton
    fun provideDicRepository(dicRepositoryImpl: DicRepositoryImpl): DicRepository =
        dicRepositoryImpl

    @Provides
    fun provideApiService(): DicApiClient {

        val builder: Retrofit.Builder = Retrofit.Builder().apply {
            baseUrl(Constant.DIC_BASE_URL)
            addConverterFactory(SimpleXmlConverterFactory.create())
        }

        val retrofit = builder
            .client(createOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(DicApiClient::class.java)

    }

    //
//    @Provides
//    fun provideAuthService(dataStore: TokenDataStore): AuthAPIClient {
//
//        val builder: Retrofit.Builder = Retrofit.Builder().apply {
//            baseUrl(Constant.URL_AUTH)
//            addConverterFactory(GsonConverterFactory.create())
//        }
//
//        val retrofit = builder
//                .client(createOkHttpClient(dataStore = dataStore, isBasicAuth = false))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//
//        return retrofit.create(AuthAPIClient::class.java)
//    }
//
//    @Provides
//    fun provideBasicAuthService(dataStore: TokenDataStore): BasicAuthAPIClient {
//
//        val builder: Retrofit.Builder = Retrofit.Builder().apply {
//            baseUrl(Constant.URL_AUTH)
//            addConverterFactory(GsonConverterFactory.create())
//        }
//
//        val retrofit = builder
//                .client(createOkHttpClient(dataStore = dataStore, isBasicAuth = true))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//
//        return retrofit.create(BasicAuthAPIClient::class.java)
//    }
//
//    @Provides
//    fun provideScalarService(dataStore: TokenDataStore) : ScalarClient {
//        val builder: Retrofit.Builder = Retrofit.Builder().apply {
//            baseUrl(Constant.URL_API)
//            addConverterFactory(ScalarsConverterFactory.create())
//        }
//
//        val retrofit = builder
//                .client(createOkHttpClient(dataStore = dataStore, isBasicAuth = false))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//
//        return retrofit.create(ScalarClient::class.java)
//    }
//
    private fun createOkHttpClient(): OkHttpClient {
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        httpClient.connectTimeout(Constant.TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(Constant.TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(Constant.TIME_OUT_SECONDS, TimeUnit.SECONDS)

        httpClient.addInterceptor(DicInterceptor())

        // デバッグ用設定
        if (BuildConfig.DEBUG) {
            httpClient.addNetworkInterceptor(StethoUtil.interceptor())
            httpClient.addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        }

        return httpClient.build()
    }
}
