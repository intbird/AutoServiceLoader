package net.intbird.soft.app.startup

import android.content.Context
import androidx.startup.Initializer
import net.intbird.soft.app.IntbirdHttp

class IntbirdHttpInit : Initializer<IntbirdHttp> {

    override fun create(context: Context): IntbirdHttp {
        return IntbirdHttp()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf(IntbirdHttpHeaderInit::class.java)
    }
}