package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var board: Array<Array<String>>
private val resultSet = mutableSetOf<String>()
private val dRow = intArrayOf(1, -1, 0, 0)
private val dCol = intArrayOf(0, 0, -1, 1)
private const val MAX = 6

fun main() {
    init()
    repeat(5) { row ->
        repeat(5) { col ->
            dfs(Position(row, col), 1, board[row][col])
        }
    }

    print(resultSet.size)
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    board = Array(5) { Array<String>(5) { "" } }
    repeat(5) { row ->
        val tk = StringTokenizer(br.readLine())
        repeat(5) { col ->
            board[row][col] = tk.nextToken()
        }
    }
}

private fun dfs(pos: Position, count: Int, value: String) {
    if (count == MAX) {
        resultSet.add(value)
        return
    }

    for (dir in 0 until 4) {
        val nextRow = pos.row + dRow[dir]
        val nextCol = pos.col + dCol[dir]

        if (nextRow !in 0 until 5 || nextCol !in 0 until 5) continue

        dfs(Position(nextRow, nextCol), count + 1, value + board[nextRow][nextCol])
    }
}

private class Position(
    val row: Int,
    val col: Int
)