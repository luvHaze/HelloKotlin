package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

private lateinit var board: Array<IntArray>
private lateinit var visitedArr: BooleanArray
private var min = Int.MAX_VALUE
private var N = 0

fun main() {
    init()
    dfs(0, 0)
    print(min)
}

private fun dfs(start: Int, count: Int) {
    if (count == N / 2) {
        val diff = calcTeamWork()
        if (diff < min) {
            min = diff
        }
        return
    }

    for (i in start until N) {
        if (visitedArr[i]) continue
        visitedArr[i] = true
        dfs(i+1, count + 1)
        visitedArr[i] = false
    }
}

private fun calcTeamWork(): Int {
    var startTeamWork = 0
    var linkTeamWork = 0
    for (row in 0 until N - 1) {
        for (col in row + 1 until N) {
            if (visitedArr[row] == true && visitedArr[col] == true) {
                startTeamWork += board[row][col]
                startTeamWork += board[col][row]
            } else if (visitedArr[row] == false && visitedArr[col] == false) {
                linkTeamWork += board[row][col]
                linkTeamWork += board[col][row]
            }
        }
    }

    return abs(startTeamWork - linkTeamWork)
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    board = Array(N) { IntArray(N) { 0 } }
    visitedArr = BooleanArray(N) { false }

    repeat(N) { row ->
        val tk = StringTokenizer(br.readLine())
        repeat(N) { col ->
            board[row][col] = tk.nextToken().toInt()
        }
    }
}