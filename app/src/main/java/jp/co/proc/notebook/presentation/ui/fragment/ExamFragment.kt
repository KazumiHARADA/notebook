package jp.co.proc.notebook.presentation.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.co.proc.notebook.R

/**
 * Created by kharada on 2019-05-01.
 */
class ExamFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_exam, container, false)
    }
}