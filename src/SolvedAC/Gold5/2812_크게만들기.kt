package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())
    val n = tk.nextToken().toInt()
    var k = tk.nextToken().toInt()

    val stack = Stack<Int>()
    val numbers = br.readLine().map {
        it.toString().toInt()
    }

    for (element in numbers) {
        while (stack.isNotEmpty() && k != 0) {
            if (stack.peek() < element) {
                stack.pop()
                k--
            } else {
                break
            }
        }
        stack.push(element)
    }

    repeat(k) {
        stack.pop()
    }

    print(stack.joinToString(""))
}

