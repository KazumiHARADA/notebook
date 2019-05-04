package jp.co.proc.notebook.presentation.di.component


import dagger.Component
import jp.co.proc.notebook.presentation.di.PerActivity
import jp.co.proc.notebook.presentation.di.modules.ActivityModule
import jp.co.proc.notebook.presentation.di.modules.FragmentModule
import jp.co.proc.notebook.presentation.ui.fragment.InputFragment

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class, FragmentModule::class])
interface FragmentComponent : ActivityComponent {
    fun inject(inputFragment: InputFragment)
    //fun inject(settingAndHelpFragment: SettingAndHelpFragment)
}
