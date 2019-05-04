package jp.co.proc.notebook.presentation.presenter

import android.util.Log
import jp.co.proc.notebook.domain.dto.WordDetail
import jp.co.proc.notebook.domain.dto.WordList
import jp.co.proc.notebook.domain.interactor.GetWordDetailUseCase
import jp.co.proc.notebook.domain.interactor.SearchWordsUseCase
import jp.co.proc.notebook.presentation.LoadDataView
import jp.co.proc.notebook.presentation.util.SimpleSingleObserver
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-01.
 */
class InputPresenter @Inject
constructor(
    private val searchWordsUseCase: SearchWordsUseCase,
    private val detailUseCase: GetWordDetailUseCase
) : Presenter() {

    private lateinit var view : InputView

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

    fun setView(view : InputView) {
        this.view = view
    }

    fun getSuggestList(inputText : String) {
        searchWordsUseCase.execute(
            object : SimpleSingleObserver<WordList>() {
                override fun onSuccess(t: WordList) {
                    super.onSuccess(t)
                    view.updateSuggestWords(t)
                }

                override fun onError(exception: Throwable) {
                    super.onError(exception)
                    Log.e("error", exception.toString());
                }
            },
            inputText
        )
    }

    fun getDetail() {
        detailUseCase.execute(
            object : SimpleSingleObserver<WordDetail>() {
                override fun onSuccess(t: WordDetail) {
                    super.onSuccess(t)
                }

                override fun onError(exception: Throwable) {
                    super.onError(exception)
                }
            },"tes"
        )
    }


    interface InputView : LoadDataView {
        fun updateSuggestWords(wordList: WordList)
    }

}