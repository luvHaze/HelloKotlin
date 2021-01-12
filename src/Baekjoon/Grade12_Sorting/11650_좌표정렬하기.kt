package Baekjoon.Grade12_Sorting

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


data class Point(
        var x: Int,
        var y: Int
) : Comparable<Point> {

    override fun compareTo(other: Point): Int {
        if (this.x > other.x) return 1
        else if (this.x == other.x) {
            if (this.y > other.y) return 1
            else if (this.y == other.y) return 0
            else return -1
        } else return -1
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cases = br.readLine().toInt()

    var arrCase = arrayListOf<Point>()
    for (i in 1..cases) {
        val token = StringTokenizer(br.readLine())
        arrCase.add(Point(
                x = token.nextToken().toInt(),
                y = token.nextToken().toInt()
        ))
    }

    arrCase.sort()
    arrCase.forEach {
        println("${it.x} ${it.y}")
    }
}