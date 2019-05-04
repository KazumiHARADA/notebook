package jp.co.proc.notebook.data.exception

/**
 * ネットワーク接続不良のエラー
 *
 * Created by kharada on 2017/08/01.
 */
class NetworkConnectionException : Exception {

    constructor() : super()

    constructor(cause: Throwable) : super(cause)
}
