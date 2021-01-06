package Baekjoon.Grade9_Math2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val r = br.readLine().toDouble()

    println(String.format("%.6f", r * r * Math.PI))
    print(String.format("%.6f", r * r * 2))
}