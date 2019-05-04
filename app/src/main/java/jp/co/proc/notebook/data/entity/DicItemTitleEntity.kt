package jp.co.proc.notebook.data.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Created by kharada on 2019-05-02.
 */
@Root(name = "DicItemTitle", strict = false)
class DicItemTitleEntity {

    @set:Element(name = "ItemID")
    @get:Element(name = "ItemID")
    var ItemID : String? = null

    @set:ElementList(entry = "Title", inline = true)
    @get:ElementList(entry = "Title", inline = true)
    var Span : List<SpanEntity>? = null
}