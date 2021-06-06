package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<IntArray>
private lateinit var visitedMap: Array<BooleanArray>
private var N = 0
private var MAX_HEIGHT = Int.MIN_VALUE
private var MIN_HEIGHT = Int.MAX_VALUE
private val dRow = intArrayOf(1, -1, 0, 0)
private val dCol = intArrayOf(0, 0, -1, 1)

fun main() {
    init()

    var maxArea = 1
    for (height in 1..MAX_HEIGHT) {
        val safeArea = getSafeArea(height)
        if(safeArea > maxArea) {
            maxArea = safeArea
        }
    }

    print(maxArea)
}

fun getSafeArea(height: Int): Int {
    visitedMap = Array(N) { BooleanArray(N) { false } }
    var safeAreaCount = 0

    for(row in 0 until N) {
        for(col in 0 until N) {
            if(map[row][col] > height && visitedMap[row][col] == false) {
                bfs(Coord2(row,col), height)
                safeAreaCount++
            }
        }
    }
    return safeAreaCount
}

private fun bfs(start: Coord2, standard_height: Int) {
    val queue: Queue<Coord2> = LinkedList<Coord2>()
    queue.add(start)
    visitedMap[start.row][start.col] = true

    while (queue.isNotEmpty()) {
        val currentCoord = queue.poll()
        for (dir in 0..3) {
            val nRow = currentCoord.row + dRow[dir]
            val nCol = currentCoord.col + dCol[dir]

            if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) continue

            if (map[nRow][nCol] > standard_height && visitedMap[nRow][nCol] == false) {
                visitedMap[nRow][nCol] = true
                queue.add(Coord2(nRow, nCol))
            }
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    map = Array(N) { IntArray(N) { 0 } }

    repeat(N) { row ->
        val tk = StringTokenizer(br.readLine())
        repeat(N) { col ->
            val height = tk.nextToken().toInt()
            map[row][col] = height

            if (height > MAX_HEIGHT) {
                MAX_HEIGHT = height
            }
            if (height < MIN_HEIGHT) {
                MIN_HEIGHT = height
            }
        }
    }
}

private class Coord2(
    val row: Int,
    val col: Int
)