package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())

    val N = tk.nextToken().toInt()
    val K = tk.nextToken().toInt()

    val number = br.readLine()

    var count = 0
    val stack = Stack<Char>()
    stack.push(number[0])
    for (idx in 1 until number.length) {
        if (stack.peek().convertInt() <= number[idx].convertInt()) {
            if (count < K) {
                stack.pop()
                count ++
            }
        }

        stack.push(number[idx])
    }

    print(stack.joinToString(""))
}

private fun Char.convertInt(): Int {
    return this.toString().toInt()
}