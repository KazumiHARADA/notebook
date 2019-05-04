package jp.co.proc.notebook.data.exception

/**
 * AccessTokenがローカルに存在しない場合のException(UserInfoのみに使用)
 */
class TokenNotFoundException : Exception {

    constructor() : super()

    constructor(cause: Throwable) : super(cause)
}
