package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.sqrt
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()

    var count = 1
    var length = 10
    var answer = 0
    for (time in 1..number) {
        if(time == length) {
            count++
            length *= 10
        }
        answer += count
    }

    print(answer)
}