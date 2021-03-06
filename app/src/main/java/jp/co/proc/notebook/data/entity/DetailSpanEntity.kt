package jp.co.proc.notebook.data.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by kharada on 2019-05-02.
 */
@Root(name = "div", strict = false)
class DetailSpanEntity {

    @set:Element(name="span")
    @get:Element(name="span")
    var span : String? = null
}