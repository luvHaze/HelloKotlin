package Baekjoon.Grade9_Math2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cases = br.readLine().toInt()

    val arrResult = IntArray(cases)
    for (c in 0 until cases) {
        val token = StringTokenizer(br.readLine())

        val x1 = token.nextToken().toInt()
        val y1 = token.nextToken().toInt()
        val r1 = token.nextToken().toInt()
        val x2 = token.nextToken().toInt()
        val y2 = token.nextToken().toInt()
        val r2 = token.nextToken().toInt()

        val value = calculate(x1, y1, r1, x2, y2, r2)
        arrResult[c] = value
    }

    arrResult.forEach {
        println(it)
    }

}

fun calculate(x1: Int, y1: Int, r1: Int, x2: Int, y2: Int, r2: Int): Int {

    val distance = ((x2 - x1).toDouble().pow(2) + (y2 - y1).toDouble().pow(2)).toInt()

    return if (distance == 0 && r1 == r2) {
        -1
    } else if (distance > (r2 + r1).toDouble().pow(2).toInt() ||
            distance < (r2 - r1).toDouble().pow(2).toInt()) {
        0
    } else if (distance == (r2 - r1).toDouble().pow(2).toInt() ||
            distance == (r2 + r1).toDouble().pow(2).toInt()) {
        1
    } else {
        2
    }
}