package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader

private var records = IntArray(100000) { -1 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()
    print(dp(number))
}

private fun dp(number: Int): Int {
    if (number == 1) return 0
    if(records[number] > 0) return records[number]
    records[number] = dp(number - 1) + 1
    if(number % 2 == 0) {
        val result = dp(number / 2) + 1
        if(result < records[number]) records[number] = result
    }
    if(number % 3 == 0) {
        val result = dp(number / 3) + 1
        if(result < records[number]) records[number] = result
    }
    return records[number]
}