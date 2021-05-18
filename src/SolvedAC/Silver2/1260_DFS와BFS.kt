package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<IntArray>
private lateinit var visitedArr: BooleanArray
private var NODE_NUMBER = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val firstToken = StringTokenizer(br.readLine())
    NODE_NUMBER = firstToken.nextToken().toInt()
    val edgeNumber = firstToken.nextToken().toInt()
    val startNode = firstToken.nextToken().toInt()

    map = Array(NODE_NUMBER + 1) { IntArray(NODE_NUMBER + 1) { 0 } }
    visitedArr = BooleanArray(NODE_NUMBER + 1) { false }
    repeat(edgeNumber) {
        val token = StringTokenizer(br.readLine())
        val from = token.nextToken().toInt()
        val to = token.nextToken().toInt()

        map[from][to] = 1
        map[to][from] = 1
    }

    dfs(startNode)
    init()
    bfs(startNode)
}

private fun dfs(node: Int) {
    visitedArr[node] = true
    print("$node ")

    for (idx in 1 until visitedArr.size) {
        if (!visitedArr[idx] && map[node][idx] == 1) {
            dfs(idx)
        }
    }
}

private fun bfs(node: Int) {
    val queue: Queue<Int> = LinkedList<Int>()
    visitedArr[node] = true
    queue.add(node)
    print("$node ")

    while (queue.isNotEmpty()) {
        val pollNode = queue.poll()
        for (idx in 1 until visitedArr.size) {
            if (!visitedArr[idx] && map[pollNode][idx] == 1) {
                visitedArr[idx] = true
                queue.add(idx)
                print("$idx ")
            }
        }
    }
}

private fun init() {
    visitedArr = BooleanArray(NODE_NUMBER + 1) { false }
    println()
}