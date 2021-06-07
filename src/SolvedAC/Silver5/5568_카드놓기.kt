package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var tNumbers: IntArray
private lateinit var numbers: IntArray
private lateinit var visitedArr: BooleanArray
private var numberSet = mutableSetOf<String>()
private var N = 0
private var K = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    K = br.readLine().toInt()

    tNumbers = IntArray(K) { 0 }
    numbers = IntArray(N) { 0 }
    visitedArr = BooleanArray(N) { false }
    repeat(N) { idx ->
        numbers[idx] = br.readLine().toInt()
    }

    dfs(0)
    println(numberSet.size)
}

private fun dfs(idx: Int) {
    if (idx == K) {
        numberSet.add(tNumbers.joinToString(""))
        return
    }

    for (i in 0 until numbers.size) {
        if (visitedArr[i]) continue
        visitedArr[i] = true
        tNumbers[idx] = numbers[i]
        dfs(idx + 1)
        visitedArr[i] = false
    }
}