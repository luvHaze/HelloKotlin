package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

private var answer = StringBuilder()
private val reverseStack = Stack<Char>()
private var isReverse = true

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()

    string.forEach {
        when (it) {
            '<' -> {
                isReverse = false
                fetchStack()
            }
            '>' -> {
                isReverse = true
            }
            ' ' -> {
                fetchStack()
            }
        }

        when (isReverse) {
            true -> {
                if (it == '>' || it == ' ') {
                    answer.append(it)
                } else {
                    reverseStack.push(it)
                }
            }
            false -> {
                answer.append(it)
            }
        }
    }
    fetchStack()

    print(answer)
}

fun fetchStack() {
    while (reverseStack.isNotEmpty()) {
        answer.append(reverseStack.pop())
    }
}