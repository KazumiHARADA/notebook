package jp.co.proc.notebook.data.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by kharada on 2019-05-02.
 */
@Root(name = "div", strict = false)
class DetailDivEntity {

    @set:Element(name="div")
    @get:Element(name="div")
    var div : String? = null
}