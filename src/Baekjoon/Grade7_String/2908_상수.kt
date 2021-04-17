package Baekjoon.Grade7_String

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val num1 = token.nextToken()
    val num2 = token.nextToken()

    val sNum1 = num1.reversed().toInt()
    val sNum2 = num2.reversed().toInt()

    if (sNum1 > sNum2) {
        print(sNum1)
    } else {
        print(sNum2)
    }
}