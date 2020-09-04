package CodingTest.BackJoon.String

fun main(){
    val sin = System.`in`.bufferedReader()
    val N = sin.readLine().toInt()
    var arr = arrayListOf<String>()
    var hash = hashMapOf<String,Int>()

    for(n in 1..N) arr.add(sin.readLine())

    for (i in arr.indices){
        var temp = arr[i].toCharArray().sorted()
        arr[i] = temp.joinToString("")
        hash[arr[i]] = 1
    }

    print(hash.keys.size)
}