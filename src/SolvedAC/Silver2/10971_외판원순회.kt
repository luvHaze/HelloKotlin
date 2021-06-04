package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<IntArray>
private lateinit var visitedMap: BooleanArray
private var min = Int.MAX_VALUE
private var N = 0

fun main() {
    init()

    for (idx in 0 until N) {
        visitedMap = BooleanArray(N) { false }
        dfs(idx, idx, 0, 0)
    }

    print(min)
}

private fun dfs(start: Int, current: Int, sum: Int, count: Int) {
    if(count == N && start == current) {
        if(sum < min) min = sum
        return
    }
    var pSum = sum

    for(idx in 0 until N) {
        if(map[current][idx] != 0 && visitedMap[current] == false) {
            visitedMap[current] = true
            pSum += map[current][idx]

            if(pSum <= min) {
                dfs(start, idx, pSum, count + 1)
            }

            visitedMap[current] = false
            pSum -= map[current][idx]
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    map = Array(N) { IntArray(N) { 0 } }
    repeat(N) { row ->
        val tk = StringTokenizer(br.readLine())
        repeat(N) { col ->
            map[row][col] = tk.nextToken().toInt()
        }
    }
}