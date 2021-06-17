package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val numbers = IntArray(N) { 0 }
    var tk  = StringTokenizer(br.readLine())
    repeat(N) { idx ->
        numbers[idx] = tk.nextToken().toInt()
    }

    numbers.sort()
    val M = br.readLine().toInt()
    tk = StringTokenizer(br.readLine())
    repeat(M) {
        val findNumber = tk.nextToken().toInt()
        if(binarySearch(numbers, findNumber)) println(1) else println(0)
    }
}

fun binarySearch(numbers: IntArray, findNumber: Int): Boolean {
    var low = 0
    var high = numbers.size - 1

    var stepCount = 0
    while(low <= high) {
        val mid = (low + high) / 2
        val guess = numbers[mid]
        stepCount++

        when {
            guess == findNumber -> {
                return true
            }
            guess > findNumber -> high = mid - 1
            else -> low = mid + 1
        }
    }

    return false
}