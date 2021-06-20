package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val string = br.readLine()

    var idx = 1
    var answer = 0
    var matchCount = 0
    while(idx < string.length - 1) {
        if (compareStdString(string, idx)) {
            matchCount++
            idx++
            if(matchCount == N) {
                matchCount--
                answer++
            }
        } else matchCount = 0
        idx++
    }
    print(answer)
}

private fun compareStdString(string: String, idx: Int): Boolean {
    return string[idx - 1] == 'I' && string[idx] == 'O' && string[idx + 1] == 'I'
}