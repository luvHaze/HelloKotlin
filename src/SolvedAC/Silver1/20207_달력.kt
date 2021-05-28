package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var scheduler: IntArray
private var N = 0
private var DAYS = 365

fun main() {
    init()
    print(solution())
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    scheduler = IntArray(DAYS + 1) { 0 }
    repeat(N) {
        val tk = StringTokenizer(br.readLine())
        val start = tk.nextToken().toInt()
        val end = tk.nextToken().toInt()

        for(idx in start..end) {
            scheduler[idx] ++
        }
    }
}

private fun solution(): Int {
    var result = 0
    var max= 0
    var con = 0
    for(idx in 1..DAYS) {
        if(scheduler[idx] > 0) {
            con ++
            max = Math.max(max, scheduler[idx])
        } else {
            result += (con * max)
            con = 0
            max = 0
        }
    }

    result += (con * max)
    return result
}
