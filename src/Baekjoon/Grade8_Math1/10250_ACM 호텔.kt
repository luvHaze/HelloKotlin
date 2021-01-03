package Baekjoon.Grade8_Math1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val H = 0
val W = 1
val C = 2

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

    var arrCase = Array(case) { IntArray(3) }
    for (i in 0 until case) {
        val token = StringTokenizer(br.readLine())
        for (j in 0 until 3) {
            arrCase[i][j] = token.nextToken().toInt()
        }
    }

    arrCase.forEach { arr ->
        var floor = arr[C] % arr[H]
        var room = (arr[C] / arr[H]) + 1
        if (floor == 0) {
            floor = arr[H]
            room = arr[C] / arr[H]
        }
        println(floor * 100 + room)
    }

}