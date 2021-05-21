package CodingTest.Programmers.SolveSample

import java.util.*

private class StringCompressSolution {
    fun solution(s: String): Int {
        var answer = 1000

        if (s.length == 1) {
            return 1
        } else {
            for (idx in 1..s.length / 2) {
                answer = Math.min(zipString(s, idx), answer)
            }
        }
        return answer
    }

    fun zipString(string: String, unit: Int): Int {
        val charStack = Stack<Char>()
        val stringStack = Stack<String>()
        var counter = 1
        var result = ""

        string.forEachIndexed { idx, char ->
            charStack.push(char)
            if (charStack.size == unit || idx == string.length - 1) {
                val join = charStack.joinToString("")
                if (stringStack.isNotEmpty()) {
                    val topString = stringStack.peek()
                    when {
                        topString == join -> {
                            counter++
                        }

                        topString != join -> {
                            result = if (counter > 1) {
                                result + counter.toString() + stringStack.pop()
                            } else {
                                result + stringStack.pop()
                            }
                            stringStack.push(join)
                            counter = 1
                        }
                    }
                } else {
                    stringStack.push(join)
                }
                charStack.clear()
            }
        }

        while (stringStack.isNotEmpty()) {
            result = if (counter > 1) {
                result + counter.toString() + stringStack.pop()
            } else {
                result + stringStack.pop()
            }
        }

        return result.length
    }
}