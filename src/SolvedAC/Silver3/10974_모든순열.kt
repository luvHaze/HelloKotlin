package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

private lateinit var numbers: IntArray
private lateinit var visitedArr: BooleanArray
private lateinit var tNumbers: IntArray
private val sb = StringBuilder()
private var N = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    numbers = IntArray(N) { it+1 }
    visitedArr = BooleanArray(N) { false }
    tNumbers = IntArray(N) { 0 }
    dfs(0)

    print(sb.toString())
}

private fun dfs(idx: Int) {
    if (idx == N) {
        tNumbers.forEach {
            sb.append("$it ")
        }
        sb.append("\n")
    }

    for(i in numbers.indices) {
        if(visitedArr[i]) continue
        visitedArr[i] = true
        tNumbers[idx] = numbers[i]
        dfs(idx + 1)
        visitedArr[i] = false
    }
}
