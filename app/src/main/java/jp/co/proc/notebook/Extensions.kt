package jp.co.proc.notebook

fun Boolean.toInt() = if (this) 1 else 0

/**
 * 文字列が数値か判定する
 * true:数値 false:数値ではない
 */
fun isNumber(num: String): Boolean {
    return try {
        Integer.parseInt(num)
        true
    } catch (e: NumberFormatException) {
        false
    }
}

fun Long.toSec() = this / 1000
