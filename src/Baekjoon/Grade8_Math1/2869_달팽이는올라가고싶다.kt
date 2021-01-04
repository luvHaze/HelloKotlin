package Baekjoon.Grade8_Math1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val a = token.nextToken().toInt()
    val b = token.nextToken().toInt()
    val v = token.nextToken().toInt()

    var day = 0
    var sum = 0L
    var lastStage = v - a
    var upPerDay = a - b

    if(lastStage % upPerDay == 0) {
        day = lastStage / upPerDay + 1
    } else {
        day = lastStage / upPerDay + 2
    }

    print(day)
}