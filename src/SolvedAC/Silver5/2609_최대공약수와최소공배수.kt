package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val num1 = token.nextToken().toInt()
    val num2 = token.nextToken().toInt()

    val small = getSmallNum(num1, num2)
    val big = getBigNum(num1, num2)
    println(getGCD(small, big))
    println(getLCM(small, big))
}

fun getGCD(small: Int, big: Int): Int {
    var result = 0

    for (num in small downTo 1 step 1) {
        if (big % num == 0 && small % num == 0) {
            result = num
            break
        }
    }

    return result
}

fun getLCM(small: Int, big: Int): Int {
    var result = 0

    var num = 1
    while (result == 0) {
        if ((big * num) % small == 0) {
            result = big * num
            break
        }
        num++
    }

    return result
}

private fun getSmallNum(num1: Int, num2: Int): Int {
    return if (num1 < num2) {
        num1
    } else {
        num2
    }
}

private fun getBigNum(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}