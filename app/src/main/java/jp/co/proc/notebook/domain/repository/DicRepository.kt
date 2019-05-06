package jp.co.proc.notebook.domain.repository

import io.reactivex.Single
import jp.co.proc.notebook.domain.dto.Word

/**
 * Created by kharada on 2019-05-02.
 */
interface DicRepository {

    fun searchSuggestWords (inputText: String) : Single<List<Word>>

    fun allSuggestWords () : Single<List<Word>>
}