package jp.co.proc.notebook.data.repository

import io.reactivex.Single
import jp.co.proc.notebook.data.api.DicApiClient
import jp.co.proc.notebook.data.mapper.WordListEntityDtoMapper
import jp.co.proc.notebook.domain.dto.WordDetail
import jp.co.proc.notebook.domain.dto.WordList
import jp.co.proc.notebook.domain.repository.DicRepository
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-02.
 */
class DicRepositoryImpl @Inject
internal constructor(
    private val dicApiClient: DicApiClient,
    private val wordListEntityDtoMapper: WordListEntityDtoMapper
) : DicRepository {
    override fun getDetail(wordId: String): Single<WordDetail> {
        return dicApiClient.detail("EJdict","011357", "", "XHTML").map {
            WordDetail()
        }
    }

    override fun searchEnglishToJapanese(inputText: String): Single<WordList> {
        return dicApiClient.search("EJdict", inputText, "HEADWORD", "STARTWITH", "AND", "XHTML", 20, 0)
            .map {
                return@map wordListEntityDtoMapper.transform(it)
            }
    }



}