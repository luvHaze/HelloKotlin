package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<CharArray>
private lateinit var visitedMap: Array<BooleanArray>
private val dRow = intArrayOf(0, 1, 0, -1)
private val dCol = intArrayOf(-1, 0, 1, 0)
private var N = 0
private var M = 0

fun main() {
    init()

    var wForce = 0
    var bForce = 0
    repeat(N) { row ->
        repeat(M) { col ->
            if (map[row][col] == 'W' && visitedMap[row][col] == false) {
                val position = Position(row, col)
                val result = searchArmy(position, 'W')
                wForce += result * result
            } else if (map[row][col] == 'B' && visitedMap[row][col] == false) {
                val position = Position(row, col)
                val result = searchArmy(position, 'B')
                bForce += result * result
            }
        }
    }

    print("$wForce $bForce")
}

private fun searchArmy(position: Position, searchSoldier: Char): Int {
    val queue: Queue<Position> = LinkedList<Position>()
    queue.offer(position)
    visitedMap[position.row][position.col] = true
    var soldier = 1

    while (queue.isNotEmpty()) {
        val pollPosition = queue.poll()
        for (dir in 0..3) {
            val nRow = pollPosition.row + dRow[dir]
            val nCol = pollPosition.col + dCol[dir]

            if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue

            if (map[nRow][nCol] == searchSoldier && visitedMap[nRow][nCol] == false) {
                soldier++
                queue.add(Position(nRow, nCol))
                visitedMap[nRow][nCol] = true
            }
        }
    }

    return soldier
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())

    M = tk.nextToken().toInt()
    N = tk.nextToken().toInt()

    map = Array(N) { CharArray(M) { ' ' } }
    visitedMap = Array(N) { BooleanArray(M) { false } }

    repeat(N) { row ->
        val line = br.readLine()
        repeat(M) { col ->
            map[row][col] = line[col]
        }
    }
}

private class Position(
    val row: Int,
    val col: Int
)