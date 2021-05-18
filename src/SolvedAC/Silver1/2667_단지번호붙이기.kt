package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<IntArray>
private lateinit var visitedMap: Array<BooleanArray>
private val br = BufferedReader(InputStreamReader(System.`in`))
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var N = 0
private var mapSize = 1

fun main() {
    init()

    var mapCount = 0
    var mapSizeList = ArrayList<Int>()
    repeat(N) { x ->
        repeat(N) { y ->
            if (map[x][y] == 1 && !visitedMap[x][y]) {
                bfs(MapNode(x, y))
                mapCount++
                mapSizeList.add(mapSize)
                mapSize = 1
            }
        }
    }
    println(mapCount)
    mapSizeList.sort()
    mapSizeList.forEach {
        println(it)
    }

}

private fun bfs(node: MapNode) {
    val queue: Queue<MapNode> = LinkedList()
    visitedMap[node.x][node.y] = true
    queue.add(node)

    while (queue.isNotEmpty()) {
        val pollNode = queue.poll()
        for (dir in 0 until 4) {
            val nx = pollNode.x + dx[dir]
            val ny = pollNode.y + dy[dir]
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue
            if (map[nx][ny] == 0 || visitedMap[nx][ny]) continue

            queue.add(MapNode(nx, ny))
            visitedMap[nx][ny] = true
            mapSize++
        }
    }
}

private fun init() {
    N = br.readLine().toInt()

    map = Array(N) { IntArray(N) { 0 } }
    visitedMap = Array(N) { BooleanArray(N) { false } }

    repeat(N) { row ->
        val arr = br.readLine()
        arr.forEachIndexed { col, char ->
            map[row][col] = char.toString().toInt()
        }
    }
}

private class MapNode(
    val x: Int,
    val y: Int
)