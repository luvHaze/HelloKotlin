package Algopa.Tast3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var shuffle = false
    val queue = LinkedList<Int>()
    val removeCard = Stack<Int>()

    for(i in n downTo 1) {
        queue.push(i)
    }

    while(queue.size != 1) {
        if(shuffle) {
            val card = queue.first
            queue.addLast(card)
            queue.removeFirst()
            shuffle = false
        } else {
            val card = queue.first
            removeCard.push(card)
            queue.removeFirst()
            shuffle = true
        }
    }
    removeCard.push(queue.pop())

    removeCard.forEach {
        print("$it ")
    }
}
