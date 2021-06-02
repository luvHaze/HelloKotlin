package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

    val results = arrayListOf<Int>()
    repeat(case) {
        var tk = StringTokenizer(br.readLine())
        val docNumber = tk.nextToken().toInt()
        val targetIndex = tk.nextToken().toInt()

        val queue: Queue<Document> = LinkedList<Document>()
        tk = StringTokenizer(br.readLine())
        repeat(docNumber) { idx ->
            val importance = tk.nextToken().toInt()
            queue.offer(Document(idx, importance))
        }

        var count = 0
        while (queue.isNotEmpty()) {
            val maxDocument = getMaxDocument(queue)
            if(queue.peek().importance == maxDocument?.importance) {
                val polledDocument = queue.poll()
                count++
                if(polledDocument.index == targetIndex) {
                    results.add(count)
                    break
                }
            } else {
                queue.offer(queue.poll())
            }
        }
    }

    results.forEach {
        println(it)
    }
}

private fun getMaxDocument(queue: Queue<Document>): Document {
    var max = Document(-1, -1)
    queue.forEach {
        if(it.importance > max.importance) {
            max = it
        }
    }
    return max
}

private data class Document(
    val index: Int,
    val importance: Int
)