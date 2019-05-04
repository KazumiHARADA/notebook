package jp.co.proc.notebook.data.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

/**
 * Created by kharada on 2019-05-02.
 */
@Root(strict = false)
class WordDetailEntity {

    @set:Element(name="ErrorMessage",required=false)
    @get:Element(name="ErrorMessage",required=false)
    var ErrorMessage : String? = null

    @set:ElementList(entry = "Head", inline = true)
    @get:ElementList(entry = "Head", inline = true)
    var Head : List<HeadDivEntity>? = null

    @set:ElementList(entry = "Body", inline = true)
    @get:ElementList(entry = "Body", inline = true)
    var Body : List<BodyDivEntity>? = null
}