package net.intbird.soft.app.auto.service

import android.content.Context
import android.widget.Toast
import com.google.auto.service.AutoService
import net.intbird.soft.app.auto.service.api.AutoServiceCallback
import net.intbird.soft.app.auto.service.api.AutoServiceInterface
import net.intbird.soft.lib.service.loader.ServicesLoader

/**
 * created by Bird
 * on 2020/5/13
 * DingTalk id: net.intbird
 */
@AutoService(AutoServiceInterface::class)
class AutoServiceImpl : AutoServiceInterface {
    override fun doToast(context: Context, content: String) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
        println(content)

        ServicesLoader.load(AutoServiceCallback::class.java).doToastResult(content)
    }
}