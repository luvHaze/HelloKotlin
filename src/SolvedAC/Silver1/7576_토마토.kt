package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<IntArray>
private lateinit var startPoint: Coord
private val queue: Queue<Coord> = LinkedList<Coord>()
private val br = BufferedReader(InputStreamReader(System.`in`))
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var ROW = 0
private var COL = 0

fun main() {
    init()
    bfs()
    printResult()
}

private fun bfs() {
    while (queue.isNotEmpty()) {
        val pollCoord = queue.poll()
        for (idx in 0..3) {
            val nx = pollCoord.x + dx[idx]
            val ny = pollCoord.y + dy[idx]

            if (nx < 0 || nx > ROW - 1 || ny < 0 || ny > COL - 1) continue
            if (map[nx][ny] == 0) {
                queue.add(Coord(nx, ny))
                map[nx][ny] = map[pollCoord.x][pollCoord.y] + 1
            }
        }
    }
}

private fun init() {
    var tk = StringTokenizer(br.readLine())
    COL = tk.nextToken().toInt()
    ROW = tk.nextToken().toInt()

    map = Array(ROW) { IntArray(COL) { 0 } }
    repeat(ROW) { x ->
        tk = StringTokenizer(br.readLine())
        repeat(COL) { y ->
            val number = tk.nextToken().toInt()
            map[x][y] = number
            if (number == 1) {
                queue.add(Coord(x, y))
            }
        }
    }
}

private fun printResult() {
    var isAllFine = true
    var maxValue = 0
    map.forEach { arr ->
        arr.forEach { count ->
            if (count == 0) isAllFine = false
            if (count >= maxValue) maxValue = count
        }
    }

    if (isAllFine) {
        print(maxValue - 1)
    } else {
        print(-1)
    }
}

private class Coord(
    val x: Int,
    val y: Int
)
