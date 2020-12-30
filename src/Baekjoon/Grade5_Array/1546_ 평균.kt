package Baekjoon.Grade5_Array

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var subject = br.readLine().toInt()
    var token = StringTokenizer(br.readLine())
    var arrSubject = FloatArray(subject)


    for (i in 0 until subject) {
        arrSubject[i] = token.nextToken().toFloat()
    }

    var result = 0F
    val MAX = arrSubject.max()
    arrSubject.forEach {
        result += (it / MAX!!) * 100
    }

    print(result/arrSubject.size)
}