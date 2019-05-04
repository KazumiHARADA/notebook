package jp.co.proc.notebook.domain.executor

import io.reactivex.Scheduler

/**
 * バックグラウンドスレッドのスケジューラ
 *
 * Created by kharada on 2017/08/01.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}
