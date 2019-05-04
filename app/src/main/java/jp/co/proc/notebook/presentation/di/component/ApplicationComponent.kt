package jp.co.proc.notebook.presentation.di.component

import android.content.Context
import dagger.Component
import jp.co.proc.notebook.domain.executor.PostExecutionThread
import jp.co.proc.notebook.domain.executor.ThreadExecutor
import jp.co.proc.notebook.domain.repository.DicRepository
import jp.co.proc.notebook.presentation.di.modules.ApplicationModule
import jp.co.proc.notebook.presentation.ui.activity.BaseActivity
import javax.inject.Singleton

/**
 * A fragmentComponent whose lifetime is the life of the application.
 */
@Singleton // Constraints this fragmentComponent to one-per-application or unscoped bindings.
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(baseActivity: BaseActivity)

    //Exposed to sub-graphs.
    fun context(): Context

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun dicRepository() : DicRepository

  //  fun memberRepository(): MemberRepository

   // fun sharedPreferences(): SharedPreferences
}
