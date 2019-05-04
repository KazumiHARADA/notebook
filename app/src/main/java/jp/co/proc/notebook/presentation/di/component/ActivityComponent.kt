package jp.co.proc.notebook.presentation.di.component

import android.app.Activity
import dagger.Component
import jp.co.proc.notebook.presentation.di.PerActivity
import jp.co.proc.notebook.presentation.di.modules.ActivityModule

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    //Exposed to sub-graphs.
    fun activity(): Activity
}
