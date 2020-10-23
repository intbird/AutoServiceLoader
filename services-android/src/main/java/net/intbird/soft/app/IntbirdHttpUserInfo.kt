package net.intbird.soft.app

data class IntbirdUserInfo(var userId: String, var userName: String?)

object IntbirdHttpUserInfo {
    var userInfo: IntbirdUserInfo? = null
}