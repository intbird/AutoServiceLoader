package net.intbird.soft.app

import net.intbird.soft.app.service.ServiceInterface
import net.intbird.soft.app.service.loader.IntbirdServiceLoader
import java.util.*

/**
 * created by Bird
 * DingTalk id: net.intbird
 */
object JavaServiceLoader {
    fun printMessage(message: String) {
        val serviceLoader: ServiceLoader<ServiceInterface> =
            ServiceLoader.load(ServiceInterface::class.java)
        for (service in serviceLoader) {
            service.doMessage(message)
        }
    }

    fun printIntbirdMessage(message: String) {
        val serviceLoader: List<ServiceInterface> =
            IntbirdServiceLoader("net/intbird").load(ServiceInterface::class.java)
        for (service in serviceLoader) {
            service.doMessage(message)
        }
    }
}

fun main() {
    JavaServiceLoader.printMessage("java service loader")
    JavaServiceLoader.printIntbirdMessage("net.intbird service loader")
}

