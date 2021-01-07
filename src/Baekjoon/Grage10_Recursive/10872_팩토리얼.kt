package Baekjoon.Grage10_Recursive

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val number = br.readLine().toInt()
    bw.write(fact(10).toString())

    bw.flush()
    bw.close()
}

fun fact(number: Long): Long = when(number) {
    0L -> 1
    1L -> 1
    else -> fact(number - 1) * number
}