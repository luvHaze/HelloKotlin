package Baekjoon.Grage10_Recursive

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()

    print(fibo(number))
}

fun fibo(N: Int): Int = when (N) {
    0 -> 0
    1 -> 1
    else -> fibo(N - 1) + fibo(N - 2)
}