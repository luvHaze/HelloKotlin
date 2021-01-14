package Baekjoon.Grade13_BackTracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

private var sb = StringBuilder()
private lateinit var arr: IntArray
private var N: Int = 0
private var M: Int = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    N = token.nextToken().toInt()
    M = token.nextToken().toInt()

    arr = IntArray(M)

    dfs(1, 0)
    println(sb)
}

private fun dfs(at: Int, depth: Int) {

    if (depth == M) {
        arr.forEach {
            sb.append(it).append(' ')
        }
        sb.append('\n')
        return
    }

    for (i in at..N) {
        arr[depth] = i
        println("[Depth] : $depth, [i] : $i [Array] : ${arr[0]} ${arr[1]}")
        dfs(i + 1, depth + 1)
    }
}