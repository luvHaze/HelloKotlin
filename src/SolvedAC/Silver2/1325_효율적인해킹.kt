package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

private lateinit var map: Array<ArrayList<Int>>
private val computers: IntArray by lazy { IntArray(N + 1) { 0 } }
private var N = 0
private var M = 0

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    init()
    for(node in 1..N) {
        val visitedArr = BooleanArray(N + 1) { false }
        dfs(node, visitedArr, computers)
    }

    var maxValue = 0
    computers.forEach {
        maxValue = max(it, maxValue)
    }
    computers.forEachIndexed { idx, conn ->
        if(conn == maxValue) {
            bw.write("$idx ")
        }
    }

    bw.flush()
    bw.close()
}

private fun dfs(node: Int, visitedArr: BooleanArray, computers: IntArray) {
    visitedArr[node] = true

    for(idx in map[node]) {
        if(!visitedArr[idx]) {
            computers[idx]++
            dfs(idx, visitedArr, computers)
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val firstToken = StringTokenizer(br.readLine())
    N = firstToken.nextToken().toInt()
    M = firstToken.nextToken().toInt()

    map = Array(N + 1) { ArrayList<Int>() }
    repeat(M) {
        val token = StringTokenizer(br.readLine())
        val from = token.nextToken().toInt()
        val to = token.nextToken().toInt()

        map[from].add(to)
    }
}