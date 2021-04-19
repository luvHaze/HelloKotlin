package Baekjoon.Grage10_Recursive

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toLong()

    convertBinary(number)
}

fun convertBinary(number: Long) {
    if(number != 1L) convertBinary(number / 2)
    print(number % 2)
}