package SolvedAC.Gold4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()
    val removeString = br.readLine()

    var removeIdx = removeString.lastIndex
    val stack = Stack<Char>()
    string.forEach { char ->
        stack.push(char)

        if (stack.peek() == removeString[removeIdx]) {
            if(stack.size >= removeString.length) {
                var isBoom = true
                repeat(removeString.length) {
                    if(stack[stack.lastIndex - it] != removeString[removeIdx - it]) {
                        isBoom = false
                    }
                }

                if(isBoom) {
                    repeat(removeString.length) {
                        stack.pop()
                    }
                }
            }
        }
    }

    val boomString = stack.joinToString("")
    if (boomString.isBlank()) {
        print("FRULA")
    } else {
        print(boomString)
    }
}
