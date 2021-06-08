package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val fiboArr = arrayListOf<Long>(0, 1)

fun main() {
    val numbers = init()

    for (number in numbers) {
        var num = number
        val stack = Stack<Long>()
        for (idx in fiboArr.size - 1 downTo 0) {
            val fiboNumber = fiboArr[idx]
            if (fiboNumber <= num) {
                num -= fiboNumber
                stack.add(fiboNumber)
            }

            if (num == 0L) break
        }

        while (stack.isNotEmpty()) {
            print("${stack.pop()} ")
        }
        println()
    }
}

private fun init(): LongArray {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

    val numbers = LongArray(case) { 0 }
    repeat(case) { idx ->
        numbers[idx] = br.readLine().toLong()
    }
    val max = getMaxNumber(numbers)
    makeFiboArr(0, 1, max)

    return numbers
}

private fun getMaxNumber(numbers: LongArray): Long {
    var max = Long.MIN_VALUE
    numbers.forEach { number ->
        if (number > max) max = number
    }
    return max
}

private fun makeFiboArr(number1: Long, number2: Long, max: Long) {
    if (number1 + number2 > max) {
        return
    }
    fiboArr.add(number1 + number2)
    makeFiboArr(number2, number1 + number2, max)
}