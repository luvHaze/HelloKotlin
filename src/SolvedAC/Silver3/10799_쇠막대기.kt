package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine().replace("()", "L")

    var answer = 0
    val stickStack = Stack<Char>()
    string.forEach { char ->
        when (char) {
            '(' -> {
                stickStack.push('I')
                answer += 1
            }
            ')' -> {
                stickStack.pop()
            }
            'L' -> {
                val size = stickStack.size
                answer += size
            }
        }
    }
    print(answer)
}