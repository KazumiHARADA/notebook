package jp.co.proc.notebook.presentation.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import jp.co.proc.notebook.AndroidApplication
import jp.co.proc.notebook.presentation.di.HasComponent
import jp.co.proc.notebook.presentation.di.component.ApplicationComponent
import jp.co.proc.notebook.presentation.di.component.DaggerFragmentComponent
import jp.co.proc.notebook.presentation.di.component.FragmentComponent
import jp.co.proc.notebook.presentation.di.modules.ActivityModule
import jp.co.proc.notebook.presentation.navigation.Navigator
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-01.
 */
abstract class BaseActivity : AppCompatActivity(), HasComponent<FragmentComponent> {

    @Inject
    lateinit var navigator: Navigator

    protected val applicationComponent: ApplicationComponent?
        get() = (application as AndroidApplication).applicationComponent


    override lateinit var fragmentComponent: FragmentComponent

    protected fun initializeInjector() {
        this.fragmentComponent = DaggerFragmentComponent.builder()
            .applicationComponent((application as AndroidApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}