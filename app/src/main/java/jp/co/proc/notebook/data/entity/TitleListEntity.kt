package jp.co.proc.notebook.data.entity

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Created by kharada on 2019-05-02.
 */
@Root(name="TitleList", strict = false)
class TitleListEntity {
    @set:ElementList(entry = "DicItemTitle", inline = true)
    @get:ElementList(entry = "DicItemTitle", inline = true)
    var dicItemTitle: List<DicItemTitleEntity>? = null
}