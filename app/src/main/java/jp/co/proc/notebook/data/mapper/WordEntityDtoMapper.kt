package jp.co.proc.notebook.data.mapper

import jp.co.proc.notebook.data.entity.WordEntity
import jp.co.proc.notebook.domain.dto.Word
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-04.
 */
class WordEntityDtoMapper @Inject
internal constructor() {

    fun transform(wordEntity: WordEntity): Word {
        val dto = Word()
        wordEntity.item_id?.let { dto.id = it }
        wordEntity.word?.let { dto.text = it }
        wordEntity.mean?.let { dto.japanese = it }
        return dto
    }
}