package jp.co.proc.notebook.data.entity

import com.google.gson.annotations.SerializedName

/**
 * 基底エンティティ
 *
 * Created by kharada on 2017/08/01.
 */
open class BaseEntity {

    @SerializedName("status")
    var status: String? = null
}
