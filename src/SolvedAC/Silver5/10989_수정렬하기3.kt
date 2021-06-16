package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val numbers = arrayListOf<Int>()
    repeat(N) {
        numbers.add(br.readLine().toInt())
    }

    print(countingSort(numbers, N))
}

fun countingSort(numbers: List<Int>, N: Int): String {
    val countMap = TreeMap<Int, Int>()
    for(number in numbers) {
        countMap[number] = countMap.getOrDefault(number, 0 ) + 1
    }

    var count = 0
    val sb = StringBuilder()
    countMap.forEach { entry ->
        val idx = entry.key
        val value = entry.value

        repeat(value) {
            sb.append("$idx\n")
        }
    }
    return sb.toString()
}