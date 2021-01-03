package Baekjoon.Grade8_Math1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()

    var section = 0
    var sum = 0
    while(section + sum < number) {
        sum += section++
    }

    val child = if(section % 2 == 0) number - sum else section+1 - (number - sum)
    val parent = section + 1 - child

    print(String.format("%d/%d", child,parent))
}