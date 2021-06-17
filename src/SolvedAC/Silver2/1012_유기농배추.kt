package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

private lateinit var ground: Array<BooleanArray>
private lateinit var visited: Array<BooleanArray>

private val dRow = intArrayOf(1, -1, 0, 0)
private val dCol = intArrayOf(0, 0, -1, 1)
private var ROW = 0
private var COL = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

    val answer = StringBuilder()
    repeat(case) {
        var tk = StringTokenizer(br.readLine())
        COL = tk.nextToken().toInt()
        ROW = tk.nextToken().toInt()
        val baechu = tk.nextToken().toInt()

        ground = Array(ROW) { BooleanArray(COL) { false } }
        visited = Array(ROW) { BooleanArray(COL) { false } }
        repeat(baechu) {
            tk = StringTokenizer(br.readLine())
            val col = tk.nextToken().toInt()
            val row = tk.nextToken().toInt()

            ground[row][col] = true
        }

        var wormCount = 0
        for (row in 0 until ROW) {
            for (col in 0 until COL) {
                if (visited[row][col] == false && ground[row][col] == true) {
                    bfs(GroundPosition(row, col))
                    wormCount++
                }
            }
        }
        answer.append("$wormCount\n")
    }

    print(answer)
}

private fun bfs(position: GroundPosition) {
    val queue: Queue<GroundPosition> = LinkedList<GroundPosition>()
    queue.offer(position)
    visited[position.row][position.col] = true

    while (queue.isNotEmpty()) {
        val pollPosition = queue.poll()

        for (dir in 0 until 4) {
            val nRow = pollPosition.row + dRow[dir]
            val nCol = pollPosition.col + dCol[dir]

            if (nRow < 0 || nRow > ROW - 1 || nCol < 0 || nCol > COL - 1) continue

            if (ground[nRow][nCol] == true && visited[nRow][nCol] == false) {
                queue.offer(GroundPosition(nRow, nCol))
                visited[nRow][nCol] = true
            }
        }
    }
}

private class GroundPosition(
    val row: Int,
    val col: Int
)