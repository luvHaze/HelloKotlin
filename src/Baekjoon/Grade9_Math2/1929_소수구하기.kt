package Baekjoon.Grade9_Math2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    val MIN = token.nextToken().toInt()
    val MAX = token.nextToken().toInt()

    val arrPrime = getPrimeList(MAX + 1)
    val result = arrPrime.filter { it >= MIN }

    result.forEach {
        println(it)
    }
}

private fun getPrimeList(MAX: Int): ArrayList<Int> {
    val arrPrime = ArrayList<Int>()
    val arrChe = BooleanArray(MAX) { false }
    arrChe[0] = true
    arrChe[1] = true

    for (i in 2 until MAX) {
        if (arrChe[i]) continue

        for (j in i * 2 until MAX step i) {
            arrChe[j] = true
        }
    }

    for (i in 2 until MAX) {
        if (!arrChe[i]) {
            arrPrime.add(i)
        }
    }

    return arrPrime
}