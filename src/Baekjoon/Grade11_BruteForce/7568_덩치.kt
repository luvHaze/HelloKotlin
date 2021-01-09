package Baekjoon.Grade11_BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val W = 0
private val H = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val arrCase = Array<IntArray>(N) { IntArray(2) }
    for (i in 0 until N) {
        val token = StringTokenizer(br.readLine())
        arrCase[i][W] = token.nextToken().toInt()
        arrCase[i][H] = token.nextToken().toInt()
    }

    for (i in 0 until N) {
        var rank = 1

        for (j in 0 until N) {
            if(i == j) continue
            if(arrCase[i][W] < arrCase[j][W] && arrCase[i][H] < arrCase[j][H] ){
                rank++
            }
        }

        print("$rank ")
    }
}