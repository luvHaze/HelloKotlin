package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<ArrayList<Int>>
private lateinit var dist: IntArray
private var N = 0
private var M = 0
private var K = 0
private var X = 0

fun main() {
    init()
    bfs(X)
    printAnswer()
}

private fun printAnswer() {
    var answer = arrayListOf<Int>()
    dist.forEachIndexed { idx, num ->
        if (num == K) answer.add(idx)
    }

    if (answer.isEmpty()) {
        print(-1)
    } else {
        answer.forEach {
            println(it)
        }
    }
}

private fun bfs(start: Int) {
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(start)
    dist[start] = 0

    while (queue.isNotEmpty()) {
        val pollNode = queue.poll()
        map[pollNode].forEach { city ->
            if (dist[city] > dist[pollNode] + 1) {
                dist[city] = dist[pollNode] + 1
                queue.add(city)
            }
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tk = StringTokenizer(br.readLine())

    N = tk.nextToken().toInt()
    M = tk.nextToken().toInt()
    K = tk.nextToken().toInt()
    X = tk.nextToken().toInt()

    map = Array(N + 1) { arrayListOf<Int>() }
    dist = IntArray(N + 1) { Int.MAX_VALUE }

    repeat(M) {
        tk = StringTokenizer(br.readLine())
        val from = tk.nextToken().toInt()
        val to = tk.nextToken().toInt()

        map[from].add(to)
    }
}