package jp.co.proc.notebook.presentation.di.component

import android.app.Activity
import dagger.Component
import jp.co.proc.notebook.presentation.di.PerActivity
import jp.co.proc.notebook.presentation.di.modules.ActivityModule

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    //Exposed to sub-graphs.
    fun activity(): Activity
}
