package intbird.soft.app.service.loader

import java.io.InputStream
import java.net.URL
import java.util.*

/**
 * created by Bird
 * DingTalk id: intbird
 */
class IntbirdServiceLoader(private val servicePath:String) {

    fun <T> load(service: Class<T>): List<T> {
        val serviceFile = "$servicePath/${service.name}"
        val serviceImpl: Enumeration<URL> = javaClass.classLoader?.getResources(serviceFile) as Enumeration<URL>

        val serviceImplResults = mutableListOf<T>()

        val implIterator = serviceImpl.iterator()
        for (impl in implIterator) {
            val fileContent = getFileContent(impl.openStream())
            val serviceNames = fileContent.split("\n".toRegex()).toTypedArray()
            for (serviceName in serviceNames) {
                val serviceClass = javaClass.classLoader?.loadClass(serviceName)
                if (serviceClass != null) {
                    val t = serviceClass.getDeclaredConstructor().newInstance() as? T
                    if (null != t) {
                        serviceImplResults.add(t)
                    }
                }
            }
        }
        return serviceImplResults
    }

    private fun getFileContent(inputStream: InputStream): String {
        val bytes = ByteArray(inputStream.available())
        inputStream.read(bytes)
        val result = String(bytes)
        inputStream.close()
        return result
    }
}