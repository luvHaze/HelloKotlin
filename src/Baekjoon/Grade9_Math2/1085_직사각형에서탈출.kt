package Baekjoon.Grade9_Math2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br= BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val x = token.nextToken().toInt()
    val y = token.nextToken().toInt()
    val w = token.nextToken().toInt()
    val h = token.nextToken().toInt()

    val arrCase = IntArray(4)

    arrCase[0] = x
    arrCase[1] = w - x
    arrCase[2] = y
    arrCase[3] = h - y

    print(arrCase.min())
}