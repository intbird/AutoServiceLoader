package intbird.soft.app.startup

import android.content.Context
import androidx.startup.Initializer
import intbird.soft.app.IntbirdHttpUserInfo
import intbird.soft.app.IntbirdUserInfo

class IntbirdHttpUserInit : Initializer<IntbirdUserInfo> {

    override fun create(context: Context): IntbirdUserInfo {
        IntbirdHttpUserInfo.userInfo = IntbirdUserInfo("intbirdId", "intbirdName")
        return IntbirdHttpUserInfo.userInfo!!
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}