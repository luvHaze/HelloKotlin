package Baekjoon.Grade9_Math2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numbers = br.readLine().toInt()

    val arrNum = IntArray(numbers)
    val token = StringTokenizer(br.readLine())
    for (i in 0 until numbers) {
        arrNum[i] = token.nextToken().toInt()
    }

    val MAX = arrNum.max()
    val arrPrime = getPrimeList(MAX!! + 1)
    var result = arrPrime.filter { arrNum.contains(it) }.size

    print("$result")
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