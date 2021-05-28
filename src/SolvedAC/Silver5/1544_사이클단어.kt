package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val wordNumber = br.readLine().toInt()

    val words = arrayListOf<String>()
    repeat(wordNumber) {
        val name = br.readLine()
        words.add(name)
    }

    words.sortByDescending { it.length }
    val notSameStack: Stack<String> = Stack<String>()
    notSameStack.push(words.removeAt(0))

    while (words.isNotEmpty()) {
        val peekWord = notSameStack.peek()
        val firstWord = words[0]
        if (peekWord.length == firstWord.length) {
            if (isSameWord(peekWord, firstWord, notSameStack)) {
                words.removeAt(0)
            } else {
                notSameStack.push(words.removeAt(0))
            }
        } else {
            notSameStack.push(words.removeAt(0))
        }
    }
    print(notSameStack.size)
}

private fun isSameWord(standard: String, target: String, notSameWords: Stack<String>): Boolean {
    val length = standard.length
    val queue: Queue<Char> = LinkedList<Char>()
    queue.addAll(target.toList())
    repeat(length) {
        queue.offer(queue.poll())
        val turnedString = queue.joinToString("")
        if (turnedString == standard || notSameWords.contains(turnedString)) {
            return true
        }
    }
    return false
}