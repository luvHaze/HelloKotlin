package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<ArrayList<Int>>
private lateinit var visited: IntArray
private var FROM = 0
private var TO = 0
private var N = 0

fun main() {
    init()
    searchFamily(FROM)
    print(visited[TO])
}

private fun searchFamily(from: Int) {
    val queue: Queue<Int> = LinkedList<Int>()
    queue.offer(from)
    visited[from] = 0

    while(queue.isNotEmpty()) {
        val families = queue.poll()

        for(family in map[families]) {
            if(family == TO) {
                visited[family] = visited[families] + 1
                return
            }

            if(visited[family] == -1) {
                queue.add(family)
                visited[family] = visited[families] + 1
            }
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    var tk = StringTokenizer(br.readLine())
    FROM = tk.nextToken().toInt()
    TO = tk.nextToken().toInt()

    map = Array(N + 1) { ArrayList<Int>() }
    visited = IntArray(N + 1) { -1 }
    val case = br.readLine().toInt()
    repeat(case) {
        tk = StringTokenizer(br.readLine())
        val from = tk.nextToken().toInt()
        val to = tk.nextToken().toInt()

        map[from].add(to)
        map[to].add(from)
    }
}