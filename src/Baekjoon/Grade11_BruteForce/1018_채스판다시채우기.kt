package Baekjoon.Grade11_BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val arrBW = arrayOf("WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW",
        "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW")

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    val N = token.nextToken().toInt()
    val M = token.nextToken().toInt()

    var arr = Array<String>(N){""}
    for (i in 0 until N) {
        arr[i] = br.readLine()
    }

    var arrCount = arrayListOf<Int>()
    for (a in 0..N - 8) {
        for (b in 0..M - 8) {
            arrCount.add(calcDiff(arr, a, b))
        }
    }

    print(arrCount.min())
}

fun calcDiff(arr: Array<String>, r: Int, c: Int): Int {

    var count= 0
    for(i in 0 until 8) {
        val temp = arr[r + i].substring(c, c+8)
        for(j in 0 until 8){
            if(temp[j] == arrBW[i][j]) count ++
        }
    }

    if(count >=32) count = 64 - count

    return count
}