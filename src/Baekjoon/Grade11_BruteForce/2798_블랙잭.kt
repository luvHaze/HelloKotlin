package Baekjoon.Grade11_BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val gameToken = StringTokenizer(br.readLine())

    val N = gameToken.nextToken().toInt()
    val M = gameToken.nextToken().toInt()

    val cardToken = StringTokenizer(br.readLine())
    val arrCard = IntArray(N)
    for (i in 0 until N) {
        arrCard[i] = cardToken.nextToken().toInt()
    }

    print(searchNum(arrCard, N, M))

}

fun searchNum(arr: IntArray, N: Int, M: Int): Int {
    var result = 0

    for (i in 0 until N - 2) {
        for (j in i + 1 until N - 1) {
            for (k in j + 1 until N) {
                val temp = arr[i] + arr[j] + arr[k]
                if (M == temp) {
                    return temp
                }
                if (temp in (result + 1) until M) {
                    result = temp
                }
            }
        }
    }

    return result
}


