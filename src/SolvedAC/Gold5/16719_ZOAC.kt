package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var visited: BooleanArray
private lateinit var string: String
private var length = 0

fun main() {
    init()
    dfs(0, length - 1)
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    string = br.readLine()
    length = string.length
    visited = BooleanArray(length) { false }
}

fun dfs(start: Int, end: Int) {
    if (start > end) {
        return
    }

    var minimumIdx = start
    for (idx in start + 1..end) {
        if (string[minimumIdx] > string[idx] && !visited[idx]) {
            minimumIdx = idx
        }
    }
    visited[minimumIdx] = true
    for (idx in 0 until length) {
        if(visited[idx]) print(string[idx])
    }
    println()

    dfs(minimumIdx + 1, end)
    dfs(start, minimumIdx - 1)
}