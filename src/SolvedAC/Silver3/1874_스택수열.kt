package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    var currentNumber = 1
    var popStack = Stack<Int>()
    val stack = Stack<Int>()
    val operStack = Stack<Char>()
    repeat(N) {
        val number= br.readLine().toInt()
        stack.push(number)
    }

    while(true) {
        val target = stack.peek()
        for(time in currentNumber until target) {
            operStack.push('+')
        }
        currentNumber++
        stack.pop()
    }

}