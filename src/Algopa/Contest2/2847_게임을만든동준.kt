package Algopa.Contest2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var number = br.readLine().toInt()

    var arrRound = ArrayList<Int>()
    for(i in 1..number) {
        arrRound.add(br.readLine().toInt())
    }

    var result = 0
    for(i in arrRound.size-1 downTo 1) {
        while(arrRound[i] <= arrRound[i-1]) {
            arrRound[i-1]--
            result++
        }
    }

    print(result)
}