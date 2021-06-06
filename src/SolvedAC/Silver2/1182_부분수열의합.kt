package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var numbers: IntArray
private var N = 0
private var S = 0
private var count = 0

fun main() {
    init()
    dfs(0, 0)
    print(count)
}

private fun dfs(idx: Int, sum: Int) {
    if(idx != 0 && sum == S) {
        count++
        return
    }

    for(i in idx until N) {
        dfs(i + 1, sum + numbers[i])
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tk = StringTokenizer(br.readLine())

    N = tk.nextToken().toInt()
    S = tk.nextToken().toInt()

    tk = StringTokenizer(br.readLine())
    numbers = IntArray(N) { 0 }
    repeat(N) { idx ->
        numbers[idx] = tk.nextToken().toInt()
    }
}