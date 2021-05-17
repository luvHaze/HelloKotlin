package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<IntArray>
private var answer = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val computerNumber = br.readLine().toInt()
    val connectNumber = br.readLine().toInt()
    map = Array(computerNumber + 1) { IntArray(computerNumber + 1) { 0 } }
    val visitedArray = BooleanArray(computerNumber + 1) { false }
    repeat(connectNumber) {
        val token = StringTokenizer(br.readLine())
        val from = token.nextToken().toInt()
        val to = token.nextToken().toInt()
        map[from][to] = 1
        map[to][from] = 1
    }

    bfs(1, visitedArray)
    println(answer)
}

fun bfs(computer: Int, visitedArray: BooleanArray) {
    val queue: Queue<Int> = LinkedList<Int>()
    visitedArray[computer] = true

    queue.add(computer)
    while (queue.isNotEmpty()) {
        val com = queue.poll()
        for (idx in 1 until map[com].size) {
            if (map[com][idx] == 1 && !visitedArray[idx]) {
                queue.add(idx)
                visitedArray[idx] = true
                answer++
            }
        }
    }
}
