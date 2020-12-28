package Algopa.Task2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var arrCang1 = ArrayList<Int>()
    var arrCang2 = ArrayList<Int>()

    for (i in 1..2) {
        var token = StringTokenizer(br.readLine())
        if (i == 1) {
            arrCang1.add(token.nextToken().toInt())
            arrCang1.add(token.nextToken().toInt())
            arrCang1.add(token.nextToken().toInt())
        } else {
            arrCang2.add(token.nextToken().toInt())
            arrCang2.add(token.nextToken().toInt())
            arrCang2.add(token.nextToken().toInt())
        }
    }

    println("${calcMaxMove(arrCang1)}")
    print(calcMaxMove(arrCang2))
}

fun calcMaxMove(arr: ArrayList<Int>): Int {
    var distance1 = arr[1] - arr[0] - 1
    var distance2 = arr[2] - arr[1] - 1

    if (distance1 >= distance2) {
        return distance1
    } else {
        return distance2
    }

}