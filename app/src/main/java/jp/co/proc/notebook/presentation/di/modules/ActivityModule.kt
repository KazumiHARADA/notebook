package jp.co.proc.notebook.presentation.di.modules

import android.app.Activity
import dagger.Module
import dagger.Provides
import jp.co.proc.notebook.presentation.di.PerActivity

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @PerActivity
    fun activity(): Activity {
        return this.activity
    }
}
