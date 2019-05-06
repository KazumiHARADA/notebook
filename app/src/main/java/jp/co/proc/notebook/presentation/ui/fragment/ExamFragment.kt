package jp.co.proc.notebook.presentation.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kidach1.tinderswipe.model.CardModel
import com.kidach1.tinderswipe.view.SimpleCardStackAdapter
import jp.co.proc.notebook.AndroidApplication
import jp.co.proc.notebook.R
import kotlinx.android.synthetic.main.fragment_exam.*


/**
 * Created by kharada on 2019-05-01.
 */
class ExamFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_exam, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardModel = CardModel("TinderSwipe", "Description for card.", "http://placehold.jp/24/cc9999/993333/350x150.png") // title, desc, imgUrl ※
        val cardAdapter = SimpleCardStackAdapter(AndroidApplication.instance.applicationContext)
        cardAdapter.add(cardModel)
        cardContainer.adapter = cardAdapter
    }
}