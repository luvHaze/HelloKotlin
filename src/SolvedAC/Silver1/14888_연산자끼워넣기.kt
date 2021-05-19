package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min

private val br = BufferedReader(InputStreamReader(System.`in`))
private val calcArr = IntArray(4) { 0 }
private lateinit var numberArr: IntArray
private var resultArr = arrayListOf<Int>()
private val arrSize by lazy { numberArr.size }

private const val PLUS = 0
private const val MINUS = 1
private const val MULTI = 2
private const val DIV = 3

private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

fun main() {
    init()
    dfs(numberArr[0], 1)
    println(max)
    println(min)
}

private fun dfs(value: Int, idx: Int) {
    if (idx == arrSize) {
        min = min(value, min)
        max = max(value, max)
        return
    }
    var calcResult = 0
    for (calc in 0..3) {
        if (calcArr[calc] > 0) {
            calcArr[calc]--
            when (calc) {
                PLUS -> {
                    calcResult = value + numberArr[idx]
                }
                MINUS -> {
                    calcResult = value - numberArr[idx]
                }
                MULTI -> {
                    calcResult = value * numberArr[idx]
                }
                DIV -> {
                    calcResult = value / numberArr[idx]
                }
            }
            dfs(calcResult, idx + 1)
            calcArr[calc]++
        }
    }
}

private fun init() {
    val numberCount = br.readLine().toInt()
    var token = StringTokenizer(br.readLine())
    numberArr = IntArray(numberCount) { 0 }
    repeat(numberCount) { idx ->
        val number = token.nextToken().toInt()
        numberArr[idx] = number
    }

    token = StringTokenizer(br.readLine())
    repeat(4) { idx ->
        val calcCount = token.nextToken().toInt()
        calcArr[idx] = calcCount
    }
}