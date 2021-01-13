package Baekjoon.Grade13_BackTracking

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

lateinit var arr: IntArray
lateinit var visit: BooleanArray
val sb = StringBuilder()

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

fun dfs(N: Int, M: Int, depth: Int) {

    if (depth == M) {
        arr.forEach {
            sb.append(it).append(' ')
        }
        sb.append('\n')
        return
    }

    for (i in 0 until N) {
        if (!visit[i]) {
            visit[i] = true
            arr[depth] = i + 1
            dfs(N, M, depth + 1)
            visit[i] = false
        }
    }
}
