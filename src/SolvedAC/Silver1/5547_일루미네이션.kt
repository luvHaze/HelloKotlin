package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private lateinit var startPoint: House

private val br = BufferedReader(InputStreamReader(System.`in`))
private val dx = intArrayOf(-1, 0, 1, 1, 1, 0)
private val dy = intArrayOf(0, -1, -1, 0, 1, 1)
private val dx2 = intArrayOf(-1, -1, 0, 1, 0, -1)
private var count = 0
private var ROW = 0
private var COL = 0

fun main() {
    init()
    bfs(House(0, 0))
    print(count)
}

private fun bfs(house: House) {
    val queue: Queue<House> = LinkedList<House>()
    queue.add(house)
    visited[house.row][house.col] = true

    while (queue.isNotEmpty()) {
        val pollNode = queue.poll()
        val x = pollNode.col
        val y = pollNode.row
        for (idx in 0..5) {
            val ny = y+ dy[idx]
            val nx = if(y % 2 == 0) {
                x + dx2[idx]
            } else {
                x + dx[idx]
            }

            if (ny < 0 || ny > ROW + 1 || nx < 0 || nx > COL + 1) continue
            if (map[ny][nx] == 1) {
                count++
            } else if (visited[ny][nx] == false) {
                queue.add(House(ny, nx))
                visited[ny][nx] = true
            }
        }
    }
}

private fun init() {
    var tk = StringTokenizer(br.readLine())
    COL = tk.nextToken().toInt()
    ROW = tk.nextToken().toInt()

    map = Array(ROW + 2) { IntArray(COL + 2) { 0 } }
    visited = Array(ROW + 2) { BooleanArray(COL + 2) { false } }
    repeat(ROW) { row ->
        tk = StringTokenizer(br.readLine())
        repeat(COL) { col ->
            val number = tk.nextToken().toInt()
            map[row + 1][col + 1] = number
        }
    }
}

private class House(
    val row: Int,
    val col: Int
)