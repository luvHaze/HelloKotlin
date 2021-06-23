package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<IntArray>
private var N = 0
private var M = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())
    N = tk.nextToken().toInt()
    M = tk.nextToken().toInt()

    map = Array(N) { IntArray(M) { 0 } }
    for (row in 0 until N) {
        val rowString = br.readLine()
        for (col in 0 until M) {
            map[row][col] = rowString[col].toString().toInt()
        }
    }

    val max_length = if (N < M) N else M

    var answer = 0
    for (length in max_length downTo 2) {
        if(findSquare(length)) {
            answer = length * length
            break
        }
    }

    if(answer != 0) {
        print(answer)
    } else {
        print(1)
    }
}

fun findSquare(length: Int): Boolean {
    for (row in 0..N - length) {
        for (col in 0..M - length) {
            val leftUp = map[row][col]
            val leftDown = map[row + length - 1][col]
            val rightUp = map[row][col + length - 1]
            val rightDown = map[row + length - 1][col + length - 1]

            if(leftUp == leftDown && rightUp == rightDown && leftUp == rightUp) return true
        }
    }

    return false
}