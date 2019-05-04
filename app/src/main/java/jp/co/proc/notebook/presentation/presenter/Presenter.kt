package jp.co.proc.notebook.presentation.presenter

/**
 * Created by kharada on 2019-05-01.
 */

abstract class Presenter {
    /**
     * Called when the presenter is initialized, this method represents the start of the presenter
     * lifecycle.
     */
    abstract fun initialize()

    /**
     * Called when the presenter is resumed. After the initialization and when the presenter comes
     * from a pause state.
     */
    abstract fun resume()

    /**
     * Called when the presenter is paused.
     */
    abstract fun pause()

    /**
     * Called when the presenter is destroied.
     */
    abstract fun destroy()
}