package jp.co.proc.notebook.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import jp.co.proc.notebook.domain.dto.Word

/**
 * Created by kharada on 2019-05-02.
 */
class InputEnglishAutoCompleteAdapter(context: Context, words: List<Word>) : ArrayAdapter<Word>(context, 0, words),
    Filterable {

    var originalWords: List<Word> = words
    private var suggestions: List<Word> = words
    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private var wordFilter: WordFilter = WordFilter()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: run {
            return@run layoutInflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false)
        }
        val word = originalWords[position]
        (view as TextView).text = word.text
        return view
    }

    override fun getFilter(): Filter {
        return wordFilter
    }

    inner class WordFilter : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            constraint?.let {
                suggestions =
                    originalWords.filter { it.text.toLowerCase().startsWith(constraint.toString().toLowerCase()) }
            } ?: run {
                suggestions = emptyList()
            }

            val filterResults = FilterResults()
            filterResults.values = suggestions
            filterResults.count = suggestions.size
            return filterResults
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) = when {
            results?.count ?: -1 > 0 -> notifyDataSetChanged()
            else -> notifyDataSetInvalidated()
        }
    }
}