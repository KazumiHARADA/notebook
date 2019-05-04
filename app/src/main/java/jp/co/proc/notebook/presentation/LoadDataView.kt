/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package jp.co.proc.notebook.presentation

/**
 * Interface representing a View that will use to load data.
 */
interface LoadDataView {
    /**
     * Show a view with a progress bar indicating a loading process.
     */
    fun showLoading()

    /**
     * Hide a loading view.
     */
    fun hideLoading()

    /**
     * Show a retry view in case of an error when retrieving data.
     */
    fun showRetry()

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    fun hideRetry()

    /**
     * Show an error
     * @param title エラータイトル
     * @param message エラーメッセージ
     * @param requestCode リクエストコード
     */
    //fun showError(title: String, message: String, requestCode: Int = RequestCode.ERROR_COMMON)
}
