package jp.co.proc.notebook.presentation.util

import io.reactivex.annotations.NonNull
import io.reactivex.observers.DisposableSingleObserver

/**
 * デフォルトのオブザーバ
 *
 * Created by kharada on 2017/08/01.
 */
open class SimpleSingleObserver<T> : DisposableSingleObserver<T>() {

    override fun onSuccess(@NonNull t: T) {}

    override fun onError(exception: Throwable) {}

}
