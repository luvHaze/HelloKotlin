package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var map: Array<CharArray>
private var R = 0
private var C = 0
private const val BLOCKED = '#'

fun main() {
    init()
    val words = arrayListOf<String>()
    for (row in map) {
        words.addAll(searchRight(row))
    }

    for (col in 0 until C) {
        words.addAll(searchDown(col))
    }
    words.sort()
    println(words[0])
}

private fun searchRight(chars: CharArray): ArrayList<String> {
    val words = arrayListOf<String>()
    var word = ""
    chars.forEach { char ->
        if(char == BLOCKED) {
            if(word.length >= 2) {
                words.add(word)
                word = ""
            } else {
                word = ""
            }
        } else {
            word += char
        }
    }
    if(word.length >= 2) words.add(word)

    return words
}

private fun searchDown(colIndex: Int): ArrayList<String> {
    val words = arrayListOf<String>()
    var word = ""
    repeat(R) { row ->
        val char = map[row][colIndex]
        if(char == BLOCKED) {
            if(word.length >= 2) {
                words.add(word)
                word = ""
            } else {
                word = ""
            }
        } else {
            word += char
        }
    }
    if(word.length >= 2) words.add(word)

    return words
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())
    R = tk.nextToken().toInt()
    C = tk.nextToken().toInt()

    map = Array(R) { CharArray(C) { ' ' } }
    repeat(R) { row ->
        val rowString = br.readLine()
        rowString.forEachIndexed { col, char ->
            map[row][col] = char
        }
    }
}