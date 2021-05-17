package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var visitedMap: Array<BooleanArray>
private lateinit var map: Array<IntArray>
private lateinit var queue: Queue<Node>
private val dx = intArrayOf(1, 0, -1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var ROW = 0
private var COL = 0
private var drawCount = 0
private var maxSize = 0

private class Node(
    var x: Int,
    var y: Int
)

fun main() {
    val firstToken = StringTokenizer(br.readLine())
    ROW = firstToken.nextToken().toInt()
    COL = firstToken.nextToken().toInt()
    map = initMap(ROW, COL)
    visitedMap = Array(ROW) { BooleanArray(COL) { false } }

    repeat(ROW) { x ->
        repeat(COL) { y ->
            if (!visitedMap[x][y] && map[x][y] == 1) {
                bfs(x, y)
            }
        }
    }

    println(drawCount)
    println(maxSize)
}

fun bfs(x: Int, y: Int) {
    queue = LinkedList<Node>()
    queue.add(Node(x, y))
    var count = 0
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        count++
        for (dir in 0 until 4) {
            val nextX = node.x + dx[dir]
            val nextY = node.y + dy[dir]
            if (nextX < 0 || nextX >= ROW || nextY < 0 || nextY >= COL) continue
            if (visitedMap[nextX][nextY] || map[nextX][nextY] == 0) continue
            visitedMap[nextX][nextY] = true
            queue.add(Node(nextX, nextY))
        }
    }
    drawCount++
    if (count > 1) {
        count--
    }
    maxSize = max(maxSize, count)
}

fun initMap(row: Int, column: Int): Array<IntArray> {
    val mapArray = Array(row) { IntArray(column) { 0 } }
    repeat(row) { x ->
        val token = StringTokenizer(br.readLine())
        repeat(column) { y ->
            mapArray[x][y] = token.nextToken().toInt()
        }
    }

    return mapArray
}