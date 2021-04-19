package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val start = token.nextToken().toInt() - 1
    val end = token.nextToken().toInt() - 1

    val arr = makeList()
    val answer = arr.slice(start..end)
        .sum()

    print(answer)
}

fun makeList(): ArrayList<Int> {
    val list = arrayListOf<Int>()
    var num = 1
    var count = 0

    for (i in 0..1000) {
        list.add(num)
        count++
        if (num == count) {
            num++
            count = 0
        }
    }
    return list
}