package intbird.soft.app

import intbird.soft.app.service.ServiceInterface
import intbird.soft.app.service.loader.IntbirdServiceLoader
import java.util.*

/**
 * created by Bird
 * DingTalk id: intbird
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
            IntbirdServiceLoader("intbird").load(ServiceInterface::class.java)
        for (service in serviceLoader) {
            service.doMessage(message)
        }
    }
}

fun main() {
    JavaServiceLoader.printMessage("java service loader")
    JavaServiceLoader.printIntbirdMessage("intbird service loader")
}

