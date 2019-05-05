package jp.co.proc.notebook.data.mapper

import jp.co.proc.notebook.data.entity.WordDetailEntity
import jp.co.proc.notebook.data.util.Kuromoji
import jp.co.proc.notebook.domain.dto.WordDetail
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-04.
 */
class WordDetailEntityDtoMapper @Inject
internal constructor(private val dicItemTitleEntityDtoMapper: DicItemTitleEntityDtoMapper) {

    fun transform(wordId: String, wordDetailEntity: WordDetailEntity): WordDetail {
        val dto = WordDetail()
        dto.id = wordId
        wordDetailEntity.Head?.get(0)?.div?.get(0)?.span?.let { dto.text = it }
        wordDetailEntity.Body?.get(0)?.div?.get(0)?.div?.let { dto.japanese = it }
        if (dto.japanese.isNotBlank()) {
            Kuromoji.tokenize(dto.japanese)
        }
        return dto
    }
}