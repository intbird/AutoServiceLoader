package intbird.soft.app

class IntbirdHttp {

    fun printHttpHeader(tag:String) {
        for (entries in IntbirdHttpHeader.map?.entries!!) {
            println(tag+" "+ entries.key + " : " + entries.value)
        }
    }
}