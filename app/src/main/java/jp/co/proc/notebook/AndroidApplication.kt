package jp.co.proc.notebook

import android.app.Application
import jp.co.proc.notebook.presentation.di.component.ApplicationComponent
import jp.co.proc.notebook.presentation.di.component.DaggerApplicationComponent
import jp.co.proc.notebook.presentation.di.modules.ApplicationModule
import jp.co.proc.notebook.presentation.util.StethoUtil


/**
 * Created by haradakazumi on 2017/07/15.
 */

class AndroidApplication : Application() {

    var userAgent: String? = null
    var applicationComponent: ApplicationComponent? = null
        private set

    companion object {
        lateinit var instance: AndroidApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        userAgent = System.getProperty("http.agent")
        this.initializeInjector()
        StethoUtil.initialize(this)
    }

    private fun initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}
