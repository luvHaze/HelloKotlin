package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var answer: LinkedList<String>
private lateinit var iter: MutableListIterator<String>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()
    val commandNumber = br.readLine().toInt()

    answer = LinkedList<String>()
    string.forEach {
        answer.add(it.toString())
    }
    iter = answer.listIterator()
    while(iter.hasNext()) iter.next()
    Math.abs(1)

    repeat(commandNumber) {
        val tk = StringTokenizer(br.readLine())
        val command = tk.nextToken()
        var addedString = ""
        if (command == "P") {
            addedString = tk.nextToken()
        }

        executeCommand(command, addedString)
    }

    print(answer.joinToString(""))
}

private fun executeCommand(command: String, addedString: String) {
    when (command) {
        "L" -> {
            if (iter.hasPrevious()) iter.previous()
        }
        "D" -> {
            if (iter.hasNext()) iter.next()
        }
        "B" -> {
            if (iter.hasPrevious()) {
                iter.previous()
                iter.remove()
            }
        }
        "P" -> {
            iter.add(addedString)
        }
    }
}

private class Comfort(
    var a: Int,
    var b: Int
):Comparable<Comfort> {
    override fun compareTo(other: Comfort): Int {
        return if(this.a > other.a) {
            1
        } else {
            -1
        }
    }
}