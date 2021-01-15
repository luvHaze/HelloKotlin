package Baekjoon.Grade13_BackTracking

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

private lateinit var arr: IntArray
private var N: Int = 0
private var count: Int = 0

fun main() {

    val br= BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    arr = IntArray(N)

    solution(0)
    println(count)

}

fun solution(depth: Int) {

    if(depth ==N) {
        count ++
        return
    }

    for(i in 0 until N) {
       arr[depth] = i

        if(isEnable(depth)) {
            solution(depth + 1)
        }
    }
}

fun isEnable(col: Int): Boolean {
    for(i in 0 until col) {
        if(arr[col] == arr[i]) {
            return false
        }
        else if(abs(col-i) == abs(arr[col] - arr[i])) {
            return false
        }
    }

    return true
}