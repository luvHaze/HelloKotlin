package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tk = StringTokenizer(br.readLine())
    val N = tk.nextToken().toInt()
    val K = tk.nextToken().toInt()

    var movement = 0
    val stacks = Array<Stack<Int>>(N) { Stack() }
    repeat(N) {
        tk = StringTokenizer(br.readLine())
        val melody = tk.nextToken().toInt()
        val pret = tk.nextToken().toInt()

        while (true) {
            if (stacks[melody].isNotEmpty()) {
                if (stacks[melody].peek() > pret) {
                    stacks[melody].pop()
                    movement++
                } else if (stacks[melody].peek() == pret) {
                    break
                } else {
                    stacks[melody].push(pret)
                    movement++
                    break
                }
            } else {
                stacks[melody].push(pret)
                movement++
                break
            }
        }
    }
    print(movement)
}
