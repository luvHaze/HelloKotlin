package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var N = 0
private var K = 0

fun main() {
    val kids = init()
    val diffs = IntArray(N) { 0 }

    for(idx in 0 until kids.size - 1) {
        val diff = kids[idx+1] - kids[idx]
        diffs[idx] = diff
    }

    var answer = 0
    diffs.sort()
    for(idx in 0..N-K) {
        answer += diffs[idx]
    }

    print(answer)
}

private fun init(): IntArray {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tk = StringTokenizer(br.readLine())

    N = tk.nextToken().toInt()
    K = tk.nextToken().toInt()

    val kids = IntArray(N) { 0 }
    tk = StringTokenizer(br.readLine())
    repeat(N) { idx ->
        kids[idx] = tk.nextToken().toInt()
    }

    return kids
}
