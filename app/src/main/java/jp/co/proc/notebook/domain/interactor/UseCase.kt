package jp.co.proc.notebook.domain.interactor

import com.google.common.base.Preconditions
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import jp.co.proc.notebook.domain.executor.PostExecutionThread
import jp.co.proc.notebook.domain.executor.ThreadExecutor


/**
 * ユースケースの基底クラス
 *
 * Created by kharada on 2017/08/01.
 */
abstract class UseCase<T, in Params> internal constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    internal abstract fun buildUseCaseSingle(params: Params): Single<T>

    fun execute(observer: DisposableSingleObserver<T>, params: Params) {
        Preconditions.checkNotNull(observer)
        val single = this.buildUseCaseSingle(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                //.compose(ErrorResponseTransformer<T>())
                .observeOn(postExecutionThread.scheduler)
        addDisposable(single.subscribeWith(observer))
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }
}
