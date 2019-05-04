package jp.co.proc.notebook.data.api

import io.reactivex.Single
import jp.co.proc.notebook.data.entity.WordDetailEntity
import jp.co.proc.notebook.data.entity.WordListEntity
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by kharada on 2019-05-02.
 */
interface DicApiClient {
    @GET("SearchDicItemLite")
    fun search(
        @Query("Dic") dic : String,
        @Query("Word") word : String,
        @Query("Scope") scope : String,
        @Query("Match") match : String,
        @Query("Merge") merge : String,
        @Query("Prof") prof : String,
        @Query("PageSize") pageSize : Int,
        @Query("PageIndex") pageIndex : Int
    ) : Single<WordListEntity>

    @GET("GetDicItemLite")
    fun detail(
        @Query("Dic") dic : String,
        @Query("Item") item : String,
        @Query("Loc") loc : String,
        @Query("Prof") prof : String
    ) : Single<WordDetailEntity>
}