package jp.co.proc.notebook

import jp.co.proc.notebook.data.util.Formatter
import jp.co.proc.notebook.data.util.Kuromoji
import org.junit.Test

/**
 * Created by kharada on 2019-05-04.
 */
class FormatterTest {
    @Test
    fun `increase動詞&名詞`() {
        var splitedList = Formatter.split("『増える』，『増大する』\t（…に）…‘を’『増やす』《＋『名』＋『ｔｏ』＋『名』》\t（…の）『増加』，増大；〈Ｃ〉増加量（額）《＋『ｏｆ』（『ｉｎ』，『ｏｎ』）＋『名』》")
        splitedList.forEach {
            Kuromoji.getSpeech(it)
        }
    }

    @Test
    fun `dictator名詞`() {
        var splitedList = Formatter.split("独裁者，専制者\t口述者")
        splitedList.forEach {
            Kuromoji.getSpeech(it)
        }
        Kuromoji.tokenize("独裁者，専制者\t口述者")
    }

    @Test
    fun `dictionary名詞`() {
        var splitedList = Formatter.split("『辞書』，辞典，字引き")
        splitedList.forEach {
            Kuromoji.getSpeech(it)
        }
    }
}