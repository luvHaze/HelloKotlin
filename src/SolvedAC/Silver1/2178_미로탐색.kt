package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var miro: Array<IntArray>
private lateinit var visitedMiro: Array<BooleanArray>
private val br = BufferedReader(InputStreamReader(System.`in`))
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var ROW = 0
private var COL = 0
private var count = 0

fun main() {
    init()
    bfs(MiroNode(0, 0))
    print(miro[ROW - 1][COL - 1])
}

private fun bfs(node: MiroNode) {
    val queue: Queue<MiroNode> = LinkedList<MiroNode>()
    queue.add(node)
    visitedMiro[node.x][node.y] = true
    while (queue.isNotEmpty()) {
        val pollNode = queue.poll()
        for (i in 0 until 4) {
            val nx = pollNode.x + dx[i]
            val ny = pollNode.y + dy[i]
            if (nx < 0 || nx >= ROW || ny < 0 || ny >= COL) continue
            if (miro[nx][ny] == 0 || visitedMiro[nx][ny]) continue
            miro[nx][ny] = miro[pollNode.x][pollNode.y] + 1
            queue.add(MiroNode(nx, ny))
            visitedMiro[nx][ny] = true
        }
    }
}

private fun init() {
    val firstToken = StringTokenizer(br.readLine())
    ROW = firstToken.nextToken().toInt()
    COL = firstToken.nextToken().toInt()

    miro = Array(ROW) { IntArray(COL) { 0 } }
    visitedMiro = Array(ROW) { BooleanArray(COL) { false } }

    repeat(ROW) { y ->
        val arr = br.readLine()
        arr.forEachIndexed { x, char ->
            miro[y][x] = char.toString().toInt()
        }
    }
}

private class MiroNode(
    var x: Int,
    var y: Int
)