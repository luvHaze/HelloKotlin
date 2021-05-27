package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val studies = init()

    val rooms = PriorityQueue<Int>()
    rooms.offer(studies[0].end)

    for (idx in 1 until studies.size) {
        if (rooms.isNotEmpty() && rooms.peek() <= studies[idx].start) rooms.poll()
        rooms.add(studies[idx].end)
    }

    print(rooms.size)
}

private fun init(): ArrayList<Study> {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val studyNumber = br.readLine().toInt()
    val studies = arrayListOf<Study>()

    repeat(studyNumber) {
        val tk = StringTokenizer(br.readLine())
        val start = tk.nextToken().toInt()
        val end = tk.nextToken().toInt()

        studies.add(Study(start, end))
    }

    studies.sortBy { it.start }
    return studies
}

private data class Study(
    val start: Int,
    val end: Int
)