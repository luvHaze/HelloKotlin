package Algopa.Contest2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var listFibo = mutableListOf<Int>(0,1)
    for(i in 2 until 47) {
        listFibo[i] = listFibo[i-1] + listFibo[i-2]
    }

    var br = BufferedReader(InputStreamReader(System.`in`))
    var cases = br.readLine().toInt()

    for(i in 0 until cases) {

    }





}