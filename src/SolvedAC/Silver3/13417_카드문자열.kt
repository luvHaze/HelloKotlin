package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

    val answer = StringBuilder()
    repeat(case) {
        val n = br.readLine().toInt()
        val strings = Array<String>(n) { "" }
        val tk = StringTokenizer(br.readLine())
        repeat(n) { idx ->
            strings[idx] = tk.nextToken()
        }

        answer.append("${getMinimumString(n, strings)}\n")
    }

    print(answer)
}

private fun getMinimumString(n:Int, strings: Array<String>): String {
    val deque = java.util.ArrayDeque<String>()
    deque.offer(strings[0])

    for(idx in 1 until n) {
        if(deque.peekFirst() >= strings[idx]) {
            deque.offerFirst(strings[idx])
        } else {
            deque.offerLast(strings[idx])
        }
    }

    return deque.joinToString("")
}