package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var answer: Array<String>
private lateinit var nodes: List<String>
private var K: Int = 0
private val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    K = br.readLine().toInt()
    nodes = br.readLine().split(" ")
    answer = Array(nodes.size / 2) { "" }

    search(0, nodes.size, 0)

    answer.forEach {
        println(it)
    }
}

private fun search(start: Int, end: Int, depth: Int) {
    if (depth == K) {
        return
    }
    val middle = (start + end) / 2
    answer[depth] += "${nodes[middle]} "
    search(start, middle - 1, depth + 1)
    search(middle + 1, end, depth + 1)
}