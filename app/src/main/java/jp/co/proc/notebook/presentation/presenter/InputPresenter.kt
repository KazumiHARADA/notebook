package jp.co.proc.notebook.presentation.presenter

import android.util.Log
import jp.co.proc.notebook.domain.dto.Word
import jp.co.proc.notebook.domain.interactor.GetAllWordsUseCase
import jp.co.proc.notebook.presentation.LoadDataView
import jp.co.proc.notebook.presentation.util.SimpleSingleObserver
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-01.
 */
class InputPresenter @Inject
constructor(
    private val getAllWordsUseCase: GetAllWordsUseCase
) : Presenter() {

    private lateinit var view: InputView

    override fun resume() {
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initialize() {

    }

    fun setView(view: InputView) {
        this.view = view
    }

    fun getSuggestList() {
        getAllWordsUseCase.execute(object : SimpleSingleObserver<List<Word>>() {
            override fun onSuccess(t: List<Word>) {
                super.onSuccess(t)
                view.updateSuggestWords(t)
            }

            override fun onError(exception: Throwable) {
                super.onError(exception)
                Log.e("error", exception.toString());
            }
        }, null)
    }

    interface InputView : LoadDataView {
        fun updateSuggestWords(wordList: List<Word>)
    }

}