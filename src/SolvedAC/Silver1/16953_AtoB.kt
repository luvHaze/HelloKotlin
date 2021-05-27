package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.util.*

private var min = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())

    val start = tk.nextToken().toLong()
    val target = tk.nextToken().toLong()

    dfs(start, 1, target)

    if (min == Int.MAX_VALUE) {
        print(-1)
    } else {
        print(min)
    }
}

private fun dfs(value: Long, count: Int, target: Long) {
    if (value == target) {
        min = count
    }
    if (value < target) {
        val addedOne = (value.toString() + "1").toLong()
        dfs(value * 2L, count + 1, target)
        dfs(addedOne, count + 1, target)
    }
}