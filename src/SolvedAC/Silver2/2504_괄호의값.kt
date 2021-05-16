package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()

    print(calcString(string))
}

fun calcString(string: String): Int {
    val stack = Stack<Char>()
    var multipleNumber = 1
    var sum = 0
    var rBracketCount = 0
    var bBracketCount = 0

    string.forEachIndexed() { index, char ->
        when (char) {
            '[' -> {
                bBracketCount++
                stack.push(char)
                multipleNumber *= 3
                if (index + 1 < string.length && string[index + 1] == ']') {
                    sum += multipleNumber
                }
            }
            '(' -> {
                rBracketCount++
                stack.push(char)
                multipleNumber *= 2
                if (index + 1 < string.length && string[index + 1] == ')') {
                    sum += multipleNumber
                }
            }
            ']' -> {
                if(checkValidation(stack, rBracketCount, bBracketCount)) {
                    bBracketCount--
                    stack.pop()
                    multipleNumber /= 3
                } else {
                    return 0
                }
            }
            ')' -> {
                if(checkValidation(stack, rBracketCount, bBracketCount)) {
                    rBracketCount--
                    stack.pop()
                    multipleNumber /= 2
                } else {
                    return 0
                }
            }
        }
    }
    if(stack.isNotEmpty() || rBracketCount !=0 || bBracketCount !=0) {
        return 0
    }

    return sum
}

fun checkValidation(stack: Stack<Char>, rCount: Int, bCount:Int): Boolean {
    return stack.isNotEmpty() && rCount >= 0 && bCount >= 0
}