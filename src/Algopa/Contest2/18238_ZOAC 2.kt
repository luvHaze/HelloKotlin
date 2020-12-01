package Algopa.Contest2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import kotlin.math.abs

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var str = br.readLine().toString()

    var beforeChar = 'A'
    var result = 0

    str.forEach {

        result += min(abs(it.toInt() - beforeChar.toInt()), 26 - abs(it.toInt()-beforeChar.toInt()))
        beforeChar = it

    }

    print(result)
}