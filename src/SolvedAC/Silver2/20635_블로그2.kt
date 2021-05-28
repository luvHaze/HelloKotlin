package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val length = br.readLine().toInt()

    val string = br.readLine()
    val compressedString = compressString(string)
    val blueCompressed = compressedString.count { it == 'B' }
    val redCompressed = compressedString.count { it == 'R' }

    if (redCompressed > blueCompressed) {
        print(1 + blueCompressed)
    } else {
        print(1 + redCompressed)
    }
}

fun compressString(string: String): String {
    val stack = Stack<Char>()
    string.forEach {
        if (stack.empty() || stack.peek() != it) {
            stack.push(it)
        }
    }

    return stack.joinToString("")
}