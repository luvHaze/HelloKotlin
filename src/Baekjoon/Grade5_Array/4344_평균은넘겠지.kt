package Baekjoon.Grade5_Array

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numClass = br.readLine().toInt()
    val arrScore = Array(numClass){ArrayList<Int>()}

    for(i in 0 until numClass) {
        val token = StringTokenizer(br.readLine())
        val numStudent = token.nextToken().toInt()
        for(s in 0 until numStudent) {
            arrScore[i].add(token.nextToken().toInt())
        }
    }

    var result = 0F
    arrScore.forEach { arr ->
        val numStd = arr.size.toFloat()
        val average = arr.average()
        val greatStd = arr.filter { it > average}.size.toFloat()

        result = (greatStd/numStd) * 100F
        println(String.format("%.3f%%", result))
    }

}