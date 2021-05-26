package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<Array<IntArray>>
private lateinit var startPoint: CoordNode
private val queue: Queue<CoordNode> = LinkedList<CoordNode>()
private val br = BufferedReader(InputStreamReader(System.`in`))
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private val dh = intArrayOf(-1, 0, 1)
private var ROW = 0
private var COL = 0
private var HEIGHT = 0

fun main() {
    init()
    bfs()
    printResult()
}

private fun bfs() {
    while (queue.isNotEmpty()) {
        val pollCoord = queue.poll()

        for (height in 0..2) {
            val nh = pollCoord.h + dh[height]
            if (nh > HEIGHT - 1 || nh < 0) continue
            if (map[nh][pollCoord.x][pollCoord.y] == 0) {
                queue.add(CoordNode(pollCoord.x, pollCoord.y, nh))
                map[nh][pollCoord.x][pollCoord.y] = map[pollCoord.h][pollCoord.x][pollCoord.y] + 1
            }

            for (dir in 0..3) {
                val nx = pollCoord.x + dx[dir]
                val ny = pollCoord.y + dy[dir]

                if (nx < 0 || nx > ROW - 1 || ny < 0 || ny > COL - 1) continue
                if (map[pollCoord.h][nx][ny] == 0) {
                    queue.add(CoordNode(nx, ny, pollCoord.h))
                    map[pollCoord.h][nx][ny] = map[pollCoord.h][pollCoord.x][pollCoord.y] + 1
                }
            }
        }
    }
}

private fun init() {
    var tk = StringTokenizer(br.readLine())
    COL = tk.nextToken().toInt()
    ROW = tk.nextToken().toInt()
    HEIGHT = tk.nextToken().toInt()

    map = Array(HEIGHT) { Array(ROW) { IntArray(COL) { 0 } } }
    repeat(HEIGHT) { h ->
        repeat(ROW) { x ->
            tk = StringTokenizer(br.readLine())
            repeat(COL) { y ->
                val number = tk.nextToken().toInt()
                map[h][x][y] = number
                if (number == 1) {
                    queue.add(CoordNode(x, y, h))
                }
            }
        }
    }

}

private fun printResult() {
    var isAllFine = true
    var maxValue = 0
    map.forEach { map ->
        map.forEach { arr ->
            arr.forEach { count ->
                print("${count}")
                if (count == 0) isAllFine = false
                if (count >= maxValue) maxValue = count
            }
            println()
        }
    }

    if (isAllFine) {
        print(maxValue - 1)

    } else {
        print(-1)
    }
}

private class CoordNode(
    val x: Int,
    val y: Int,
    val h: Int
)
