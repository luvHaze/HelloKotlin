package Baekjoon.Grade7_String

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()

    var arrTimes = ArrayList<Int>()
    var arrString = ArrayList<String>()

    for (i in 1..number) {
        val token = StringTokenizer(br.readLine())
        arrTimes.add(token.nextToken().toInt())
        arrString.add(token.nextToken().toString())
    }

    for (i in 0 until arrTimes.size) {
        val time = arrTimes[i]
        var string = ""
        arrString[i].forEach {
            for(i in 1..time) {
                string += it
            }
        }
        println(string)
    }

}