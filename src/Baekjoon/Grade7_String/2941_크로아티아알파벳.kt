package Baekjoon.Grade7_String

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()

    val transArr = arrayOf("dz=", "c=", "c-","d-", "lj", "nj", "s=", "z=")


    var result = string
    transArr.forEach {
        result = result.replace(it, "*")
    }

    print(result.length)
}