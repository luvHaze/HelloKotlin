package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val cards = HashMap<Int, Int>()
    var tk = StringTokenizer(br.readLine())

    repeat(N) { idx ->
        val number = tk.nextToken().toInt()
        cards[number] = cards.getOrDefault(number, 0) + 1
    }

    val M = br.readLine().toInt()
    val wantedCards = IntArray(M) { 0 }
    tk = StringTokenizer(br.readLine())
    val answer = StringBuilder()
    repeat(M) { idx ->
        val card = tk.nextToken().toInt()
        answer.append("${findCard(cards, card)} ")
    }

    print(answer)
}

fun findCard(cards: HashMap<Int, Int>, find: Int): Int {
    return cards[find] ?: 0
}