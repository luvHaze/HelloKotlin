package Baekjoon.Grade12_Sorting

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val arr = arrayListOf<Int>()
    for(i in 1..N) {
        arr.add(br.readLine().toInt())
    }

    arr.sort()
    arr.forEach {
        println(it)
    }
}