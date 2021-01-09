package Baekjoon.Grade11_BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    var result = 0

    for (i in 0 until N) {
        var number = i
        var sum = 0

        while (number != 0) {
            sum += number % 10
            number /= 10
        }

        if (sum + i == N) {
            result = i
            break
        }
    }

    print(result)
}