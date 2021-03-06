package Baekjoon.Grade9_Math2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arrCase = ArrayList<Int>()
    while(true) {
        val num = br.readLine().toInt()
        if(num != 0) {
            arrCase.add(num)
        } else {
            break
        }
    }

    arrCase.forEach {
        val MIN = it
        val MAX = it * 2

        val arrPrime = getPrimeList(MAX + 1)
        val result = arrPrime.filter { prime -> prime > MIN }.size

        println(result)
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
