package SolvedAC.Bronze1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    while(sc.hasNext()) {
        val strings = sc.nextLine().split(" ")
        val pattern = strings[0].toList()
        val parent = strings[1]

        val queue: Queue<Char> = LinkedList<Char>()
        queue.addAll(pattern)

        parent.forEach {
            if (queue.peek() == it) {
                queue.poll()
            }
        }

        if (queue.isEmpty()) {
            println("Yes")
        } else {
            println("No")
        }
    }
}
