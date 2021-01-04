package Baekjoon.Grade8_Math1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    val a = token.nextToken().toLong()
    val b = token.nextToken().toLong()
    val c = token.nextToken().toLong()

    val benefit = c - b
    if (benefit <= 0L) {
        print(-1)
    } else {
        print((a / benefit) + 1)
    }
}