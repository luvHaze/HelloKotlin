package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val n = token.nextToken().toInt()
    val k = token.nextToken().toInt()

    val list = LinkedList<Int>()
    for (i in 1..n) {
        list.add(i)
    }

    var position = k - 1
    print("<")
    while (list.isNotEmpty()) {
        if (list.size == 1) {
            print("${list.removeAt(position)}")
        } else {
            print("${list.removeAt(position)}, ")
        }

        if (list.isEmpty()) {
            break
        } else {
            position = (position + (k - 1)) % list.size
        }
    }
    print(">")
}