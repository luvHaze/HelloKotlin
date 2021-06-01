package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())

    val N = tk.nextToken().toInt()
    val K = tk.nextToken().toInt()

    val humans:Queue<Int> = LinkedList<Int>()
    repeat(N) { human ->
        humans.offer(human + 1)
    }

    val pollHumans = arrayListOf<Int>()
    var count = 1
    while (humans.isNotEmpty()) {
        if(count == K) {
            pollHumans.add(humans.poll())
            count = 1
        } else {
            humans.offer(humans.poll())
            count ++
        }
    }
    print("<")
    print(pollHumans.joinToString(", "))
    print(">")
}