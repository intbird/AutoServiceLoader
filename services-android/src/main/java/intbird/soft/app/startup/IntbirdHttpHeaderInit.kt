package intbird.soft.app.startup

import android.content.Context
import androidx.startup.Initializer
import intbird.soft.app.IntbirdHttpHeader
import intbird.soft.app.IntbirdHttpUserInfo

class IntbirdHttpHeaderInit : Initializer<Map<String, String?>> {

    override fun create(context: Context): Map<String, String?> {
        IntbirdHttpHeader.map = mapOf(
            "userId" to IntbirdHttpUserInfo.userInfo?.userId,
            "userName" to IntbirdHttpUserInfo.userInfo?.userName
        )
        return IntbirdHttpHeader.map!!
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf(IntbirdHttpUserInit::class.java)
    }
}