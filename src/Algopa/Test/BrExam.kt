package Algopa.Test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tokenDay = StringTokenizer(br.readLine())
    val day = tokenDay.nextToken().toInt()

    val arrScore = ArrayList<Int>()
    for(i in 1..day) {
        arrScore.add(StringTokenizer(br.readLine()).nextToken().toInt())
    }

    var result = 0
    var maxScore = 0
    arrScore.forEach {
        if(it > maxScore) {
            result += it
            maxScore = it
        }
    }

    print("$result")

    var a = intArrayOf(1,2,3)
    var da = a.distinct().toIntArray()
}
