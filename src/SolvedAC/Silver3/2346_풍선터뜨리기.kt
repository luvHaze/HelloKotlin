package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val balloonNumber = br.readLine().toInt()

    val token = StringTokenizer(br.readLine())
    val balloonDeque = ArrayDeque<Pair<Int, Int>>()

    for (index in 1..balloonNumber) {
        val value = token.nextToken().toInt()
        balloonDeque.add(Pair(index, value))
    }

    repeat(balloonNumber) {
        print("${balloonDeque.peekFirst().first} ")

        val times = balloonDeque.remove().second
        if (balloonDeque.size > 1) {
            if (times > 0) {
                repeat(times - 1) {
                    balloonDeque.add(balloonDeque.remove())
                }
            } else {
                repeat(times * -1) {
                    balloonDeque.addFirst(balloonDeque.removeLast())
                }
            }
        }
    }
}
