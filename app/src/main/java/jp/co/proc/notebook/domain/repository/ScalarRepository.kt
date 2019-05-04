package jp.co.proc.notebook.domain.repository

import io.reactivex.Single

/**
 * plain/text形式のデータを返却するAPIのリポジトリ
 */
interface ScalarRepository {

    /**
     * 個人情報保護方針の改訂日取得
     */
    fun getPrivacyPolicyRevisionDate(): Single<String>

}