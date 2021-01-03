package Baekjoon.Grade8_Math1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var weight = br.readLine().toInt()

    var count = 0

    while(true) {
        if(weight % 5 == 0) {
            print(weight / 5 + count)
            break
        } else if(weight <= 0) {
            print(-1)
            break
        }
        weight -= 3
        count++
    }
}