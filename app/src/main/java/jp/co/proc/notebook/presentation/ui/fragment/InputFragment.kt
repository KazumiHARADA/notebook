package jp.co.proc.notebook.presentation.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import jp.co.proc.notebook.domain.dto.WordList
import jp.co.proc.notebook.presentation.presenter.InputPresenter
import jp.co.proc.notebook.presentation.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.fragment_input.*
import javax.inject.Inject


/**
 * Created by kharada on 2019-05-01.
 */
class InputFragment : Fragment(), InputPresenter.InputView {
    override fun updateSuggestWords(wordList: WordList) {
        mAutoCompleteAdapter?.clear()
        for (word in wordList.words) {
            mAutoCompleteAdapter?.add(word.text)
        }
        //mAutoCompleteAdapter?.originalWords = wordList.words
        mAutoCompleteAdapter?.notifyDataSetChanged()
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRetry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideRetry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var mContext: Context

    @Inject
    lateinit var mInputPresenter: InputPresenter

    var mAutoCompleteAdapter: ArrayAdapter<String>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (activity as BaseActivity).fragmentComponent.inject(this)
        return inflater.inflate(jp.co.proc.notebook.R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mInputPresenter.setView(this)
        mAutoCompleteAdapter = ArrayAdapter<String>(
            mContext,
            android.R.layout.simple_dropdown_item_1line,
            emptyList()
        )//InputEnglishAutoCompleteAdapter(mContext, emptyList())
        inputEnglish.setAdapter(mAutoCompleteAdapter)
        button.setOnClickListener { mInputPresenter.getDetail() }

    }

    override fun onResume() {
        super.onResume()
        inputEnglish.addTextChangedListener(InputTextWatcher())
    }

    inner class InputTextWatcher : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (s?.length ?: 0 > 2) {
                mInputPresenter.getSuggestList(s.toString())
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }
}
