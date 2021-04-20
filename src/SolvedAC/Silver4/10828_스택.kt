package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class MyStack() {
    private var top: Node? = null

    fun push(item: Int) {
        val node = Node(item)
        node.next = top
        top = node
    }

    fun pop(): Int {
        if (top == null) return -1

        val item = top!!.data
        top = top!!.next

        return item
    }

    fun size(): Int {
        if (top == null) return 0

        var size = 1
        var node = top
        while (node!!.next != null) {
            node = node.next
            size++
        }

        return size
    }

    fun empty(): Int {
        return if (top == null) 1 else 0
    }

    fun top(): Int {
        return top?.data ?: -1
    }

    inner class Node(item: Int) {
        var data: Int = item
        var next: Node? = null
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val commandNumber = br.readLine().toInt()
    val sb = StringBuilder()

    val stack = MyStack()
    repeat(commandNumber) {
        val tokenizer = StringTokenizer(br.readLine())
        val command = tokenizer.nextToken()

        var value = 0
        if (command.startsWith("push")) {
            value = tokenizer.nextToken().toInt()
        }

        processCommand(stack, command, value)?.let {
            sb.append("$it\n")
        }
    }
    print(sb.trim())
}

fun processCommand(stack: MyStack, command: String, value: Int?): String? {
    return when (command) {
        "push" -> {
            value?.let { stack.push(it) }
            null
        }
        "pop" -> {
            stack.pop().toString()
        }
        "top" -> {
            stack.top().toString()
        }
        "empty" -> {
            stack.empty().toString()
        }
        "size" -> {
            stack.size().toString()
        }
        else -> {
            throw IllegalStateException("잘못된 커멘드 입니다.")
        }
    }
}

