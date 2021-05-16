package SolvedAC.Gold4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stdString = br.readLine()
    val pattern = br.readLine()

    print(kmp(stdString, pattern))
}

private fun getLpsTable(string: String): IntArray {
    val patternSize = string.length
    val table = IntArray(patternSize) { 0 }
    var j = 0

    for (i in 1 until patternSize) {
        while (j > 0 && string[i] != string[j]) {
            j = table[j - 1]
        }
        if (string[i] == string[j]) {
            table[i] = ++j
        }
    }

    return table
}

private fun kmp(standard: String, pattern: String): Int {
    val lpsTable: IntArray = getLpsTable(pattern)
    val standardSize = standard.length
    val patternSize = pattern.length
    var answer = 0

    var j = 0
    for (i in 0 until standardSize) {
        while (j > 0 && standard[i] != pattern[j]) {
            j = lpsTable[j - 1]
        }
        if (standard[i] == pattern[j]) {
            if (j == patternSize - 1) {
                answer = 1
                break
            } else {
                j++
            }
        }
    }

    return answer
}