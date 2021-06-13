package SolvedAC.Gold4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var N = 0
private var K = 0
private var enableLearn = 0
private var visited: BooleanArray = BooleanArray(26) { false }
private var charSet = TreeSet<Char>()
private lateinit var words: Array<String>
private var max = Int.MIN_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())
    N = tk.nextToken().toInt()
    K = tk.nextToken().toInt()
    enableLearn = K - 5
    words = Array(N) { "" }

    repeat(N) { idx ->
        val string = br.readLine().replace("[antic]".toRegex(), "")
        charSet.addAll(string.toList())
        words[idx] = string
    }

    visited['a'.toIndex()] = true
    visited['n'.toIndex()] = true
    visited['t'.toIndex()] = true
    visited['i'.toIndex()] = true
    visited['c'.toIndex()] = true

    when {
        K >= 5 -> {
            searchAllCombi(0, 0)
            print(max)
        }
        K == 26 -> {
            print(N)
        }
        else -> {
            print(0)
        }
    }
}

private fun searchAllCombi(idx: Int, count: Int) {
    if (count == enableLearn) {
        var cnt = 0
        for (word in words) {
            var canRead = true
            for (char in word) {
                if (!visited[char.toIndex()]) {
                    canRead = false
                    break
                }
            }

            if (canRead) cnt++
        }

        if (cnt > max) max = cnt
        return
    }

    for (i in idx until 26) {
        if (!visited[i] && charSet.contains(i.toCharIndex())) {
            visited[i] = true
            searchAllCombi(idx + 1, count + 1)
            visited[i] = false
        }
    }
}


fun Char.toIndex(): Int {
    return this - 'a'
}

fun Int.toCharIndex(): Char{
    return (this + 'a'.toInt()).toChar()
}