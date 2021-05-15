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
                bBracketCount--
                stack.pop()
                multipleNumber /= 3
            }
            ')' -> {
                rBracketCount--
                stack.pop()
                multipleNumber /= 2
            }
        }
    }
    if (stack.isEmpty() || rBracketCount != 0 || bBracketCount != 0) {
        return 0
    }

    return sum
}