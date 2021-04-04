package CodingTest.BackJoon.DFS_BFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val computers = br.readLine().toInt()
    val networks = br.readLine().toInt()

    val array = Array(computers + 1) { IntArray(computers + 1) }
    repeat(networks) {
        val token = StringTokenizer(br.readLine())
        val from = token.nextToken().toInt()
        val to = token.nextToken().toInt()
        array[from][to] = 1
        array[to][from] = 1
    }

    print(bfs(array, computers))
}

fun bfs(array: Array<IntArray>, N: Int): Int {
    val visitedArray = Array<Boolean>(N + 1) { false }
    val queue: LinkedList<Int> = LinkedList<Int>()

    var count = 0
    queue.push(1)
    visitedArray[1] = true
    while (queue.isNotEmpty()) {
        for (i in 1..N) {
            if (array[queue.first][i] == 1 && !visitedArray[i]) {
                queue.push(i)
                visitedArray[i] = true
                count ++
            }
        }
        queue.removeFirst()
    }

    return count
}