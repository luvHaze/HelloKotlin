package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var times: IntArray
private var min = Int.MAX_VALUE
private var N = 0
private var K = 0
private var count = 0
private const val UP = 0
private const val DOWN = 1
private const val BLINK = 2

fun main() {
    init()

    if (N >= K) {
        println(N-K)
        println(1)
    } else {
        bfs(N)
        println(min)
        println(count)
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())

    N = tk.nextToken().toInt()
    K = tk.nextToken().toInt()
    times = IntArray(1000001) { 0 }
}

private fun bfs(init: Int) {
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(init)
    times[init] = 1

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        if (min < times[now]) return
        for (move in 0 until 3) {
            var next = 0
            when (move) {
                UP -> next = now + 1
                DOWN -> next = now - 1
                BLINK -> next = now * 2
            }

            if (next < 0 || next > 100000) continue

            if (next == K) {
                min = times[now]
                count++
            }

            if(times[next] == 0 || times[next] == times[now] + 1) {
                queue.add(next)
                times[next] = times[now] + 1
            }
        }
    }
}

