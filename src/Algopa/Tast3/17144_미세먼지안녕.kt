package Algopa.Tast3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    val ROW = token.nextToken().toInt()
    val COL = token.nextToken().toInt()
    val TIME = token.nextToken().toInt()

    val arrMap = Array(ROW){IntArray(COL)}

    for(r in 0 until ROW) {
        token = StringTokenizer(br.readLine())
        for(c in 0 until COL) {
            arrMap[r][c] = token.nextToken().toInt()
        }
    }

    arrMap.forEach { arr ->
        arr.forEach {
            print("$it ")
        }
        println("")
    }
}