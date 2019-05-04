package jp.co.proc.notebook

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import jp.co.proc.notebook.domain.executor.PostExecutionThread
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MainThread (UI Thread) implementation based on a [Scheduler]
 * which will execute actions on the Android UI thread
 */
@Singleton
class UIThread @Inject
internal constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}
