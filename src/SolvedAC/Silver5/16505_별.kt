package SolvedAC.Silver5

import kotlin.math.pow

private lateinit var board: Array<CharArray>
private var N = 0

fun main() {
    N = readLine()!!.toInt()
    val power = 2.0.pow(N.toDouble()).toInt()
    board = Array(power) { CharArray(power) { ' ' } }
    markStar(0, 0, power)

    repeat(power) { row ->
        repeat(power) { col ->
            print(board[row][col])
        }
        println()
    }
}

private fun markStar(row: Int, col: Int, length: Int) {
    if(length == 1) {
        board[row][col] = '*'
        return
    }

    val halfLength = length / 2
    markStar(row, col, halfLength)
    markStar(row, col + halfLength, halfLength)
    markStar(row+ halfLength, col, halfLength)
}