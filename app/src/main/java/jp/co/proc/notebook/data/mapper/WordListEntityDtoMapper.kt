package jp.co.proc.notebook.data.mapper

import jp.co.proc.notebook.data.entity.WordListEntity
import jp.co.proc.notebook.domain.dto.WordList
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-02.
 */
class WordListEntityDtoMapper @Inject
internal constructor(private val dicItemTitleEntityDtoMapper: DicItemTitleEntityDtoMapper) {

    fun transform(wordListEntity: WordListEntity) : WordList {
        val dto = WordList()
        wordListEntity.ItemCount?.let { dto.itemCount = it.toInt() }
        wordListEntity.TotalHitCount?.let { dto.totalHitCount = it.toInt() }
        wordListEntity.TitleList?.let { dto.words = it.dicItemTitle?.map { item -> dicItemTitleEntityDtoMapper.transform(item) } ?: emptyList() }
        return dto
    }
}