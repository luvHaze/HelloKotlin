package CodingTest.Programmers.Level2

import java.util.*

class PrinterSolution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var queue: Queue<Document> = LinkedList()
        val docs = priorities.mapIndexed { idx, value ->
            Document(idx, value)
        }
        queue.addAll(docs)
        var maxDoc = getMaxPrior(queue)

        while (queue.isNotEmpty()) {
            val headDoc = queue.peek()
            if (headDoc == maxDoc) {
                queue.poll()
                answer++
                if (queue.isNotEmpty()) maxDoc = getMaxPrior(queue)
                if (headDoc.index == location) break
            } else {
                queue.add(queue.poll())
            }
        }

        return answer
    }

    private fun getMaxPrior(queue: Queue<Document>): Document {
        return queue.maxBy { it.prior }!!
    }

    data class Document(
        var index: Int,
        var prior: Int
    )
}