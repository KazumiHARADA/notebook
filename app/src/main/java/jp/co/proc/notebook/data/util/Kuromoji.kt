package jp.co.proc.notebook.data.util

import com.atilika.kuromoji.ipadic.Tokenizer

/**
 * Created by kharada on 2019-05-04.
 */
class Kuromoji {

    enum class SpeechType {
        NOUN, // 名詞
        PRONOUN, //代名詞
        ADJECTIVE, //形容詞
        VERB, //動詞
        ADVERB, //副詞
        PREPOSITION, //前置詞
        CONJUNCTION, //接続詞
        INTERJECTION //間投詞
    }

    companion object {
        fun tokenize(text : String) {
            val tokenizer = Tokenizer()
            val tokens = tokenizer.tokenize(text)
            tokens.forEach {
                println(it.surface)
                println(it.allFeatures)
            }
        }

        fun getSpeech(text : String) {
            val targetText = text.replace("『","")
                .replace("』", "")
                .replace("《.*".toRegex(), "")
                .replace("（.*）".toRegex(), "")
                .replace("〈.*〉".toRegex(), "")
                .replace("‘.*’".toRegex(), "")
            if (!targetText.contains("》")) {
                tokenize(targetText)
            }
        }
    }
}