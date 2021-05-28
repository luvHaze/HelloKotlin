package SolvedAC.Gold4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val caseNumber = br.readLine().toInt()

    val answer = StringBuilder()
    repeat(caseNumber) {
        val pq = PriorityQueue<Long>()
        val chapterNumber = br.readLine().toInt()
        val tk = StringTokenizer(br.readLine())
        repeat(chapterNumber) {
            pq.add(tk.nextToken().toLong())
        }

        var sum = 0L
        while (pq.size > 1) {
            val num1 = pq.poll()
            val num2 = pq.poll()
            sum += num1 + num2
            pq.add(num1 + num2)
        }

        answer.append(sum)
        answer.append("\n")
    }

    print(answer)
}