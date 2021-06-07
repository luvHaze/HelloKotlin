package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

private lateinit var numbers: IntArray
private lateinit var tempNumbers: IntArray
private lateinit var visited: BooleanArray
private var N = 0
private var result = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    val tk = StringTokenizer(br.readLine())
    numbers = IntArray(N) { 0 }
    visited = BooleanArray(N) { false }
    tempNumbers = IntArray(N) { 0 }
    repeat(N) { idx ->
        numbers[idx] = tk.nextToken().toInt()
    }

    numbers.sort()
    dfs(0)
    println(result)
}

private fun dfs(count: Int) {
    if (count == N) {
        var sum = 0
        for (idx in 0 until N - 1) {
            sum += abs(tempNumbers[idx] - tempNumbers[idx + 1])
        }
        if (result < sum) result = sum
        return
    }

    for (idx in 0 until N) {
        if (visited[idx]) continue
        visited[idx] = true
        tempNumbers[count] = numbers[idx]
        dfs(count + 1)
        visited[idx] = false
    }
}