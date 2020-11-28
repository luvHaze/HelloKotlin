package Algopa.Task1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var number = br.readLine().toLong()

    var num: Int = 1
    var result : Int = 0

    var sum: Long = 0

    while(true) {

        sum += num
        result++

        if(sum > number) {
            result--
            break
        }
        num ++
    }

    print(result)
}