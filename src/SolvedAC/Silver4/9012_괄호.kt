package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val caseNumber = br.readLine().toInt()
    val stringBuilder = StringBuilder()

    repeat(caseNumber) {
        val ps = br.readLine()
        stringBuilder.append("${isVPS(ps)}\n")
    }

    print(stringBuilder.trim())
}

fun isVPS(ps: String): String {
    val stack = Stack<Char>()
    ps.forEach {
        if (it == '(') stack.push('(')
        if (it == ')') {
            if (stack.isEmpty()) return "NO"
            else stack.pop()
        }
    }
    return if (stack.isEmpty()) "YES" else "NO"
}