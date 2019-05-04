package jp.co.proc.notebook.data.mapper

import jp.co.proc.notebook.data.entity.DicItemTitleEntity
import jp.co.proc.notebook.domain.dto.Word
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-02.
 */
class DicItemTitleEntityDtoMapper @Inject
internal constructor() {

    fun transform(dicItemTitleEntity: DicItemTitleEntity) : Word {
        val dto = Word()
        dicItemTitleEntity.ItemID?.let { dto.id = it }
        dicItemTitleEntity.Span?.get(0)?.span?.let { dto.text = it }
        return dto
    }
}