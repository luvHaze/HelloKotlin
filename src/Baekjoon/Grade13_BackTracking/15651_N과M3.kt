package Baekjoon.Grade13_BackTracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

private lateinit var arr: IntArray
private lateinit var visit: BooleanArray
private val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    var N = token.nextToken().toInt()
    var M = token.nextToken().toInt()

    arr = IntArray(M)
    visit = BooleanArray(N)
    dfs(N, M, 0)
    System.out.println(sb)
}

private fun dfs(N: Int, M: Int, depth: Int) {

    if (depth == M) {
        arr.forEach {
            sb.append(it).append(' ')
        }
        sb.append('\n')
        return
    }

    for (i in 1..N) {
        arr[depth] = i
        dfs(N, M, depth+1)
    }
}