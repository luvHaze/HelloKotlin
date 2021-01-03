package Baekjoon.Grade9_Math2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val num = br.readLine().toInt()

    var arr = IntArray(num)
    for(i in arr.indices) {
        arr[i] = i
    }

}
