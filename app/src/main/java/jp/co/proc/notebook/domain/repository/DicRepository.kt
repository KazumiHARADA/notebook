package jp.co.proc.notebook.domain.repository

import io.reactivex.Single
import jp.co.proc.notebook.domain.dto.WordDetail
import jp.co.proc.notebook.domain.dto.WordList

/**
 * Created by kharada on 2019-05-02.
 */
interface DicRepository {

    fun searchEnglishToJapanese(inputText: String): Single<WordList>

    fun getDetail(wordId: String) : Single<WordDetail>
}