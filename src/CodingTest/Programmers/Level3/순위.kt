package CodingTest.Programmers.Level3

import java.util.*

private class SolutionRank {

    private lateinit var map: Array<IntArray>
    private lateinit var visitArr: BooleanArray
    private var N = 0
    private val WIN = 1
    private val LOSE = 2

    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        N = n
        init(results)
        for (idx in 1..N) {
            val w = bfs(idx, WIN)
            val l = bfs(idx, LOSE)
            println("$w $l")
            if (w + l == N - 1) answer++
        }
        println(answer)
        return answer
    }

    fun bfs(node: Int, findNumber: Int): Int {
        val queue: Queue<Int> = LinkedList<Int>()
        val visitedArray = IntArray(N + 1) { 0 }
        queue.add(node)
        visitedArray[node] += 1

        while (queue.isNotEmpty()) {
            val pollNode = queue.poll()
            for (idx in 1..N) {
                if (visitedArray[idx] == 0 && map[pollNode][idx] == findNumber) {
                    queue.add(idx)
                    visitedArray[idx] = visitedArray[pollNode] + 1
                }
            }
        }

        return visitedArray.count {
            it != 0
        } - 1
    }

    fun init(results: Array<IntArray>) {
        map = Array(N + 1) { IntArray(N + 1) { 0 } }

        results.forEach {
            val winner = it[0]
            val loser = it[1]
            map[winner][loser] = WIN
            map[loser][winner] = LOSE
        }
    }
}