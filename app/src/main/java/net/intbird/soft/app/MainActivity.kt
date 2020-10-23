package net.intbird.soft.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.startup.AppInitializer
import com.google.auto.service.AutoService
import net.intbird.soft.app.auto.service.api.AutoServiceCallback
import net.intbird.soft.app.auto.service.api.AutoServiceInterface
import intbid.soft.app.R
import net.intbird.soft.app.startup.IntbirdHttpInit
import net.intbird.soft.lib.service.loader.ServicesLoader

private val TAG = "MainActivityTag: "

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //java service loader
        JavaServiceLoader.printMessage("${TAG}java service loader")
        //java custom service loader
        JavaServiceLoader.printIntbirdMessage("${TAG}net.intbird service loader")

        //google auto service
        ServicesLoader.load(AutoServiceInterface::class.java).doToast(this, "${TAG}Toast google service loader")

        //startup
        val http = AppInitializer.getInstance(applicationContext).initializeComponent(IntbirdHttpInit::class.java)
        http.printHttpHeader(TAG)
    }

    @AutoService(value = [AutoServiceCallback::class]) // SOURCE
    class ServiceCallback : AutoServiceCallback {
        override fun doToastResult(result: String) {
           println("${TAG}doToastResult: $result")
        }
    }
}
