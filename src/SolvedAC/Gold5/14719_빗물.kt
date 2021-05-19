package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private const val EMPTY = 0
private const val FULL = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tk = StringTokenizer(br.readLine())

    val ROW = tk.nextToken().toInt()
    val COL = tk.nextToken().toInt()

    val bowl = Array(ROW) { IntArray(COL) { EMPTY } }
    tk = StringTokenizer(br.readLine())
    repeat(COL) { col ->
        val markedSpace = tk.nextToken().toInt()
        repeat(markedSpace) { row ->
            bowl[ROW - 1 - row][col] = FULL
        }
    }

    var answer = 0
    repeat(ROW) { row ->
        var isFull = false
        var waterSpace = 0
        bowl[row].forEach { space ->
            if (isFull) {
                if (space == EMPTY) {
                    waterSpace++
                } else {
                    answer += waterSpace
                    waterSpace = 0
                }
            } else {
                isFull = space == FULL
            }
        }
    }

    print(answer)
}