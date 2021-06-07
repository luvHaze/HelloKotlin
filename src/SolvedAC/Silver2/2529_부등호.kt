package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var signs: CharArray
private lateinit var numbers: IntArray
private lateinit var tempArr: IntArray
private lateinit var visitedArr: BooleanArray
private const val MAX = 10
private var SIGN = 0
private var answers = arrayListOf<String>()

fun main() {
    init()
    dfs(0)

    println(answers.last())
    print(answers.first())
}

private fun dfs(idx: Int) {
    if (idx == SIGN + 1) {
        var isValid = true
        for (i in 0 until SIGN) {
            when (signs[i]) {
                '>' -> isValid = tempArr[i] > tempArr[i + 1]
                '<' -> isValid = tempArr[i] < tempArr[i + 1]
            }
            if (!isValid) break
        }

        if (isValid) {
            answers.add(tempArr.joinToString(""))
            return
        }
        return
    }

    for (i in 0 until MAX) {
        if (visitedArr[i]) continue
        visitedArr[i] = true
        tempArr[idx] = numbers[i]
        dfs(idx + 1)
        visitedArr[i] = false
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    SIGN = br.readLine().toInt()
    val tk = StringTokenizer(br.readLine())

    numbers = IntArray(MAX) { it }
    visitedArr = BooleanArray(MAX) { false }
    tempArr = IntArray(SIGN + 1) { 0 }
    signs = CharArray(SIGN) { ' ' }
    repeat(SIGN) { idx ->
        signs[idx] = tk.nextToken()[0]
    }
}