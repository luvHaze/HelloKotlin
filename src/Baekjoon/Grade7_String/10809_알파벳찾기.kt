package Baekjoon.Grade7_String

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()
    val a =  97

    val arrAlpha = IntArray(26){-1}
    for(i in string.indices) {
        val numASC = string[i].toInt()

        if(arrAlpha[numASC-a] == -1) {
            arrAlpha[numASC-a] = i
        }
    }

    arrAlpha.forEach { print("$it ") }
}