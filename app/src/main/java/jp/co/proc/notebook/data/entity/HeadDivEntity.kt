package jp.co.proc.notebook.data.entity

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Created by kharada on 2019-05-02.
 */
@Root(name = "Head", strict = false)
class HeadDivEntity {

    @set:ElementList(entry = "div", inline = true)
    @get:ElementList(entry = "div", inline = true)
    var div : List<DetailSpanEntity>? = null
}