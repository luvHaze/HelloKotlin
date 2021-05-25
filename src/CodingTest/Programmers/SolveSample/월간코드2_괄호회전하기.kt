package CodingTest.Programmers.SolveSample

import java.util.LinkedList
import java.util.Stack
import java.util.Queue

private class BracketRotateSolution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val table: Queue<Char> = LinkedList<Char>()

        table.addAll(s.toList())
        repeat(s.length) {
            if(checkTable(table.joinToString(""))) answer++
            val pollChar = table.poll()
            table.add(pollChar)
        }
        return answer
    }

    fun checkTable(string: String): Boolean {
        val stack = Stack<Char>()
        string.forEach{ char ->
            when(char) {
                '}' -> {
                    if(stack.isNotEmpty()) {
                        if(stack.peek() == '{') {
                            stack.pop()
                        } else {
                            stack.push(char)
                        }
                    } else {
                        return false
                    }
                }
                ')' -> {
                    if(stack.isNotEmpty()) {
                        if(stack.peek() == '(') {
                            stack.pop()
                        } else {
                            stack.push(char)
                        }
                    } else {
                        return false
                    }
                }
                ']' -> {
                    if(stack.isNotEmpty()) {
                        if(stack.peek() == '[') {
                            stack.pop()
                        } else {
                            stack.push(char)
                        }
                    } else {
                        return false
                    }
                }
                else -> {
                    stack.push(char)
                }
            }
        }

        return stack.isEmpty()
    }
}