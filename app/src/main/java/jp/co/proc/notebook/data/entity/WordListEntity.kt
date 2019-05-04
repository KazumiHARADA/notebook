package jp.co.proc.notebook.data.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by kharada on 2019-05-02.
 */
@Root(strict = false)
class WordListEntity {

    @set:Element(name="ErrorMessage",required=false)
    @get:Element(name="ErrorMessage",required=false)
    var ErrorMessage : String? = null

    @set:Element(name="TotalHitCount")
    @get:Element(name="TotalHitCount")
    var TotalHitCount : String? = null

    @set:Element(name="ItemCount")
    @get:Element(name="ItemCount")
    var ItemCount : String? = null

    @set:Element(name="TitleList")
    @get:Element(name="TitleList")
    var TitleList : TitleListEntity? = null
}