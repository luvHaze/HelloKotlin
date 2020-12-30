package Baekjoon.Grade6_Function

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()

    var result = 0

    for (i in 1..number) {
        if (checkHansu(i)) result++
    }

    println(result)
}

fun checkHansu(n: Int): Boolean {
    var number = n

    when (n) {
        in 1..99 -> {
            return true
        }

        1000 -> {
            return false
        }

        else -> {
            val arrJari = ArrayList<Int>()
            while (number > 0) {
                arrJari.add(number % 10)
                number /= 10
            }

            return arrJari[0] - arrJari[1] == arrJari[1] - arrJari[2]
        }
    }

}