package jp.co.proc.notebook.data.util

/**
 * Created by kharada on 2019-05-04.
 */
class Formatter {

    companion object {
        fun split(text: String) : List<String> {
            return text.replace("\t","，")
                .replace("；","，")
                .split("，")
        }
    }
}