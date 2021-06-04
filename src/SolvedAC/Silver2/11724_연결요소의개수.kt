package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<IntArray>
private lateinit var visitedMap: BooleanArray
private var N = 0
private var M = 0

fun main() {
    init()

    var count = 0
    for(city in 1..N) {
        if(visitedMap[city] == false) {
            bfs(city)
            count++
        }
    }

    print(count)
}

private fun bfs(start: Int) {
    val queue: Queue<Int> = LinkedList<Int>()
    queue.offer(start)
    visitedMap[start] = true

    while(queue.isNotEmpty()) {
        val currentNode = queue.poll()
        for(idx in 1..N) {
            if(map[currentNode][idx] == 1 && visitedMap[idx] == false) {
                queue.add(idx)
                visitedMap[idx] = true
            }
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tk = StringTokenizer(br.readLine())
    N = tk.nextToken().toInt()
    M = tk.nextToken().toInt()

    map = Array(N+1) { IntArray(N+1) { 0 } }
    visitedMap = BooleanArray(N+1) { false }
    repeat(M) {
        tk = StringTokenizer(br.readLine())
        val from = tk.nextToken().toInt()
        val to = tk.nextToken().toInt()

        map[from][to] = 1
        map[to][from] = 1
    }
}

private class Node(
    val from: Int,
    val to: Int
)