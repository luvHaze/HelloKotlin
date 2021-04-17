package Baekjoon.Grade7_String

import java.io.BufferedReader
import java.io.InputStreamReader

private const val a = 97
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val wordNumber = br.readLine().toInt()
    var answer = 0

    repeat(wordNumber) {
        val string = br.readLine()
        if (isGroupWord(string)) {
            answer++
        }
    }
    print(answer)
}

fun isGroupWord(string: String): Boolean {
    var result = true
    val checker = Array<Boolean>(26) { false }

    for (i in 1 until string.length) {
        val beforeChar = string[i - 1]
        val currentChar = string[i]

        if (currentChar != beforeChar) {
            if (checker[string[i].toInt() - a] == true) {
                result = false
                break
            }
            checker[string[i - 1].toInt() - a] = true
        }
    }
    return result
}