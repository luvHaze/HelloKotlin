package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val numbers = IntArray(N) { 0 }
    val tk = StringTokenizer(br.readLine())
    repeat(N) { idx ->
        numbers[idx] = tk.nextToken().toInt()
    }

    val indexMap = HashMap<Int, Int>()
    val sortNumbers = numbers.sorted().distinct()
    sortNumbers.forEachIndexed { index, value ->
        if(indexMap[value] == null) indexMap[value] = index
    }

    val answer = StringBuilder()
    repeat(N) { idx ->
        answer.append("${indexMap[numbers[idx]]} ")
    }
    print(answer)
}