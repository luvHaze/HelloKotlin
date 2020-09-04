package CodingTest


fun main(){

    var hash = hashMapOf<String, Int>("kim" to 1, "Jeon" to 2, "Dim" to 3)
    var hashInt = hashMapOf<Int, Int>(3 to 1, 2 to 2, 6 to 3)
    var arr = arrayListOf<Int>(1,3,5,6,7,8,99)

    var a = hash.values.groupBy {it>2}.map { it.value }
    a.forEach {
        println("$it ")
    }

}

