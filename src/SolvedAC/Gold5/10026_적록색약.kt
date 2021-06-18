package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var pictureMap: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private val dRow = intArrayOf(1, -1, 0, 0)
private val dCol = intArrayOf(0, 0, -1, 1)
private var N = 0

fun main() {
    init()

    println("${whenNormal()} ${whenWeakness()}")
}

private fun whenWeakness(): Int {
    visited = Array(N) { BooleanArray(N) { false } }
    var r = 0
    var b = 0

    for(row in 0 until N) {
        for(col in 0 until N) {
            if(pictureMap[row][col] == 'G') pictureMap[row][col] = 'R'
        }
    }

    for (row in 0 until N) {
        for (col in 0 until N) {
            if (visited[row][col] == false) {
                findSection(PicPosition(row, col), pictureMap[row][col])
                when(pictureMap[row][col]) {
                    'R' -> r ++
                    'B' -> b ++
                }
            }
        }
    }

    return r + b
}

private fun whenNormal(): Int {
    var r = 0
    var g = 0
    var b = 0

    for (row in 0 until N) {
        for (col in 0 until N) {
            if (visited[row][col] == false) {
                findSection(PicPosition(row, col), pictureMap[row][col])
                when(pictureMap[row][col]) {
                    'R' -> r ++
                    'G' -> g ++
                    'B' -> b ++
                }
            }
        }
    }
    return r + g + b
}

private fun findSection(startPoint: PicPosition, searchColor: Char) {
    val queue: Queue<PicPosition> = LinkedList<PicPosition>()
    queue.offer(startPoint)
    visited[startPoint.row][startPoint.col] = true

    while (queue.isNotEmpty()) {
        val currentPos = queue.poll()
        for (dir in 0 until 4) {
            val nextRow = currentPos.row + dRow[dir]
            val nextCol = currentPos.col + dCol[dir]

            if (nextRow < 0 || nextRow > N - 1 || nextCol < 0 || nextCol > N - 1) continue

            if (pictureMap[nextRow][nextCol] == searchColor && visited[nextRow][nextCol] == false) {
                visited[nextRow][nextCol] = true
                queue.offer(PicPosition(nextRow, nextCol))
            }
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    pictureMap = Array(N) { CharArray(N) { ' ' } }
    visited = Array(N) { BooleanArray(N) { false } }

    for (row in 0 until N) {
        val rowString = br.readLine()
        for (col in 0 until N) {
            pictureMap[row][col] = rowString[col]
        }
    }
}

private class PicPosition(
    val row: Int,
    val col: Int
)

