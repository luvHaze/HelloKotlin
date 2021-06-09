package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var N = 0
private var K = 0
private lateinit var visitedArr: BooleanArray
private lateinit var table: CharArray

fun main() {
    init()

    var count = 0
    for (idx in 0 until N) {
        if (visitedArr[idx]) continue
        if (table[idx] == 'P') {
            if (search(idx)) count++
        }
    }

    print(count)
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())
    N = tk.nextToken().toInt()
    K = tk.nextToken().toInt()

    table = br.readLine().toCharArray()
    visitedArr = BooleanArray(N) { false }
}

private fun search(idx: Int): Boolean {
    return when (idx) {
        0 -> searchRight(idx)
        N - 1 -> searchLeft(idx)
        else -> {
            if (!searchLeft(idx)) {
                searchRight(idx)
            } else {
                true
            }
        }
    }
}

private fun searchLeft(idx: Int): Boolean {
    for (i in idx - K until idx) {
        if (i < 0 || i > N - 1) continue
        if (table[i] == 'H' && visitedArr[i] == false) {
            visitedArr[idx] = true
            visitedArr[i] = true
            return true
        }
    }
    return false
}

private fun searchRight(idx: Int): Boolean {
    for (i in idx + 1..idx + K) {
        if (i < 0 || i > N - 1) continue
        if (table[i] == 'H' && visitedArr[i] == false) {
            visitedArr[idx] = true
            visitedArr[i] = true
            return true
        }
    }
    return false
}
