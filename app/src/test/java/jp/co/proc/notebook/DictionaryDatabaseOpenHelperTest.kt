package jp.co.proc.notebook

import jp.co.proc.notebook.presentation.util.DictionaryDatabaseOpenHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Created by kharada on 2019-05-04.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, application = AndroidApplication::class)
class DictionaryDatabaseOpenHelperTest {

    @Test
    fun `select`() {
        val helper =  DictionaryDatabaseOpenHelper(RuntimeEnvironment.application)
        helper.getSuggestWords("add")
    }

}