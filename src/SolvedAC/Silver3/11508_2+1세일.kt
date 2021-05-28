package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()

    val array = IntArray(number) { 0 }
    repeat(number) { idx ->
        array[idx] = br.readLine().toInt()
    }

    var sum = 0
    array.sortDescending()
    array.forEachIndexed { idx, num ->
        if((idx+1) % 3 != 0) {
            sum += num
        }
    }

    print(sum)
}


