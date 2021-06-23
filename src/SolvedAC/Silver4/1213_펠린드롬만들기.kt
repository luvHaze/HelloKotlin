package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()
    val alphaMap = IntArray(26) { 0 }
    for (char in string) {
        val index = char - 'A'
        alphaMap[index] = alphaMap[index] + 1
    }

    val left = StringBuilder()
    val right = StringBuilder()
    var mid = ""
    var oddCount = 0
    for (idx in 0 until 26) {
        if (alphaMap[idx] % 2 != 0) {
            mid += idx.toUpperChar()
            oddCount++
        }
    }
    if(oddCount >= 2) {
        print("I'm Sorry Hansoo")
        return
    } else {
        for (idx in 0 until 26) {
            if (alphaMap[idx] != 0) {
                while (alphaMap[idx] > 1) {
                    left.append(idx.toUpperChar())
                    right.insert(0, idx.toUpperChar())
                    alphaMap[idx] -= 2
                }
            }
        }
        print("$left$mid$right")
    }
}

fun Int.toUpperChar(): Char {
    return (this + 'A'.toInt()).toChar()
}