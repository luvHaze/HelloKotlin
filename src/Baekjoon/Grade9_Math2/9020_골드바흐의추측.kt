package Baekjoon.Grade9_Math2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cases = br.readLine().toInt()

    val arrCases = ArrayList<Int>()
    for(i in 1..cases) {
        arrCases.add(br.readLine().toInt())
    }

    arrCases.forEach {
        val arrPrime = getPrimeList(it + 1)
        var prime1 = it / 2
        var prime2 = it / 2

        while(true) {
            if(arrPrime.contains(prime1) && arrPrime.contains(prime2)) {
                println("$prime1 $prime2")
                break
            } else {
                prime1--
                prime2++
            }
        }

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