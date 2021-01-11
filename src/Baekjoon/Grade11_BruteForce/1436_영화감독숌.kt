package Baekjoon.Grade11_BruteForce

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    var count = 1
    var target = 666
    while(count != N) {
        target++

        if(target.toString().contains("666")) {
            count++
        }
    }

    print(target)

}