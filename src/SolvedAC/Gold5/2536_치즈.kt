package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var board: Array<IntArray>
private lateinit var visitBoard: Array<BooleanArray>
private const val WAYS = 4
private const val CHEESE = 1
private const val BLANK = 0
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var ROW = 0
private var COL = 0

fun main() {
    init()

    val cheeseRecord = arrayListOf<Int>()
    cheeseRecord.add(countCheese())
    var counter = 0
    while (true) {
        counter++
        bfs(BoardNode(counter, counter))
        visitBoard = Array(ROW + 2) { BooleanArray(COL + 2) { false } }
        val cheeseCount = countCheese()
        if(cheeseCount == 0) {
            break
        } else {
            cheeseRecord.add(cheeseCount)
        }
    }

    println(counter)
    print(cheeseRecord.last())
}

private fun bfs(node: BoardNode) {
    val queue: Queue<BoardNode> = LinkedList<BoardNode>()
    queue.offer(node)
    visitBoard[node.row][node.col] = true

    while (queue.isNotEmpty()) {
        val pollNode = queue.poll()
        for (idx in 0 until WAYS) {
            val nx = pollNode.row + dx[idx]
            val ny = pollNode.col + dy[idx]

            if (nx < 0 || nx > ROW + 1 || ny < 0 || ny > COL + 1) continue

            if (visitBoard[nx][ny] == false && board[nx][ny] == BLANK) {
                queue.add(BoardNode(nx, ny))
                visitBoard[nx][ny] = true
            } else if (visitBoard[nx][ny] == false && board[nx][ny] == CHEESE) {
                board[nx][ny] = BLANK
                visitBoard[nx][ny] = true
            }
        }
    }
}

private fun countCheese(): Int {
    var sum = 0
    board.forEach { row ->
        sum += row.count { it == CHEESE }
    }
    return sum
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tk = StringTokenizer(br.readLine())
    ROW = tk.nextToken().toInt()
    COL = tk.nextToken().toInt()

    board = Array(ROW + 2) { IntArray(COL + 2) { BLANK } }
    visitBoard = Array(ROW + 2) { BooleanArray(COL + 2) { false } }
    repeat(ROW) { row ->
        tk = StringTokenizer(br.readLine())
        repeat(COL) { col ->
            board[row + 1][col + 1] = tk.nextToken().toInt()
        }
    }
}

private class BoardNode(
    var row: Int,
    var col: Int
)