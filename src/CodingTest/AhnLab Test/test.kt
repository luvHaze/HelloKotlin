import java.io.BufferedReader
import java.util.*

fun main() {
    var sc = arrayListOf(25,40,65,110)
    var temp = arrayListOf<Int>()
    var answer = 0
    var t = 1

    sc.forEach {
        var num = it/t
        num = it-(num*t)
        if(answer < num) answer=num
    }
    
    println(answer)
}