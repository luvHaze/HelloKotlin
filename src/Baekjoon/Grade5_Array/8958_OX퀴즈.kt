package Baekjoon.Grade5_Array

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val caseNum = br.readLine().toInt()

    var arrCase = arrayOfNulls<String>(caseNum)
    for (i in 0 until caseNum) {
        arrCase[i] = br.readLine()
    }

    var stackScore = 0
    var result = 0
    arrCase.forEach { str ->
        str!!.forEach { char ->
            when (char) {
                'O' -> {
                    stackScore++
                    result += stackScore
                }
                'X' -> {
                    stackScore = 0
                }
            }

        }
        println(result)
        stackScore = 0
        result = 0
    }
}
