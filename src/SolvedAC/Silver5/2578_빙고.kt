package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private const val N = 5
private const val GOAL = 3
private val br = BufferedReader(InputStreamReader(System.`in`))
private val board = Array(5) { IntArray(5) { 0 } }
private val checkBoard = Array(5) { BooleanArray(5) { false } }

fun main() {
    init()
    print("\n${callNumber()}")
}

fun callNumber(): Int {
    var calledCount = 0
    repeat(N) {
        val token = StringTokenizer(br.readLine())
        repeat(N) {
            val calledNumber = token.nextToken().toInt()
            calledCount++
            markBoard(calledNumber)
            if (calledCount >= 10) {
                if (checkBingo()) return calledCount
            }
        }
    }
    return calledCount
}

private fun checkBingo(): Boolean {
    val bingoCount = checkRow() + checkCol() + checkCross()
    return bingoCount >= GOAL
}

private fun checkRow(): Int {
    var bingoCount = 0
    for (col in 0 until N) {
        if (checkBoard[0][col] == true) {
            var count = 0
            for (row in 0 until N) {
                if (checkBoard[row][col]) count++
            }
            if (count == 5) bingoCount++
        }
    }
    return bingoCount
}

private fun checkCol(): Int {
    var bingoCount = 0
    for (row in 0 until N) {
        if (checkBoard[row][0] == true) {
            var count = 0
            for (col in 0 until N) {
                if (checkBoard[row][col]) count++
            }
            if (count == 5) bingoCount++
        }
    }
    return bingoCount
}

private fun checkCross(): Int {
    var bingoCount = 0
    if (checkBoard[0][0] == true) {
        var count = 0
        for (idx in 0 until N) {
            if (checkBoard[idx][idx] == true) count++
        }

        if (count == 5) bingoCount++
    }

    if (checkBoard[0][N - 1] == true) {
        var count = 0
        for (idx in 0 until N) {
            if (checkBoard[0 + idx][N - 1 - idx] == true) count++
        }

        if (count == 5) bingoCount++
    }
    return bingoCount
}

private fun markBoard(number: Int) {
    var isFound = false

    for (row in 0 until N) {
        for (col in 0 until N) {
            if (board[row][col] == number) {
                checkBoard[row][col] = true
                isFound = true
                break
            }
        }
        if (isFound == true) break
    }
}

private fun init() {
    repeat(N) { row ->
        val token = StringTokenizer(br.readLine())
        repeat(N) { col ->
            board[row][col] = token.nextToken().toInt()
        }
    }
}

