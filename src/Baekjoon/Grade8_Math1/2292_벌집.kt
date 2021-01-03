package Baekjoon.Grade8_Math1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var cnt = 1
    var range = 1L
    var tmp = 1L

    while(true) {
        if(range >= n) {
            break
        }
        tmp = (6 * (cnt++)).toLong()
        range += tmp
    }

    print(cnt)
}
