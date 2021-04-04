package Baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    var arrRoad = IntArray(N-1)
    var token = StringTokenizer(br.readLine())
    for (i in 0 until N - 1) {
        arrRoad[i] = token.nextToken().toInt()
    }

    token = StringTokenizer(br.readLine())
    var arrCity = IntArray(N)
    for (i in 0 until N) {
        arrCity[i] = token.nextToken().toInt()
    }
}