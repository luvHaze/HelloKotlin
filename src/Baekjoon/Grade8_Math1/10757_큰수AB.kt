package Baekjoon.Grade8_Math1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    val num1 = token.nextToken().toBigInteger()
    val num2 = token.nextToken().toBigInteger()

    print(num1 + num2)
}