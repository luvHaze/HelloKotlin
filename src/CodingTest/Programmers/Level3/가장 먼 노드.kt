package CodingTest.Programmers.Level3

import java.util.*

private class SolutionNode {

    private lateinit var adjList: Array<LinkedList<Int>>
    private lateinit var visitArray: IntArray
    private var N = 0

    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        N = n
        init(edge)

        bfs(1)

        val max = visitArray.max()
        answer = visitArray.count {
            it == max
        }

        return answer
    }

    fun bfs(node: Int) {
        val queue: Queue<Int> = LinkedList()
        queue.add(node)
        visitArray[node] += 1

        while(queue.isNotEmpty()) {
            val pollNode = queue.poll()

            adjList[pollNode].forEach{ n ->
                if(visitArray[n] == 0) {
                    queue.add(n)
                    visitArray[n] = visitArray[pollNode] + 1
                }
            }
        }

    }

    fun init(edge: Array<IntArray>) {
        adjList = Array(N + 1) { LinkedList<Int>() }
        visitArray = IntArray(N + 1) { 0 }
        edge.forEach{
            adjList[it[0]].add(it[1])
            adjList[it[1]].add(it[0])
        }
    }
}