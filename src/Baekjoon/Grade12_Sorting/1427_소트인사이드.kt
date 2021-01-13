package Baekjoon.Grade12_Sorting

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var num = br.readLine()

    val arrNum = mutableListOf<Char>()
    num.forEach { arrNum.add(it) }

    arrNum.sortDescending()
    print(arrNum.joinToString(""))

}