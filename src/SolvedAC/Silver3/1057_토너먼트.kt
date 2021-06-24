package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())

    var N = tk.nextToken().toInt()
    var min = tk.nextToken().toInt()
    var soo = tk.nextToken().toInt()

    var round = 0
    while(min != soo) {
        round++
        min = (min / 2) + (min % 2)
        soo = (soo / 2) + (soo % 2)
    }

    print(round)
}