package Baekjoon.Grade7_String

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var string = br.readLine().trim()

    var result= 0
    if(string.isEmpty()) {
        result = 0
    }else {
        result = string.split(' ').size
    }

    print(result)
}