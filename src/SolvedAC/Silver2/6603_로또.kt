package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var numbers: IntArray
private var size = 0
private var count = 0
private var sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val line = br.readLine()
        if (line == "0") break
        val numbers = init(line)

        repeat(numbers.size - 5) { idx ->
            count = 1
            dfs(idx, "${numbers[idx]} ")
        }
        sb.append("\n")
    }
    print(sb.toString())
}

private fun init(line: String): IntArray {
    val tk = StringTokenizer(line)
    size = tk.nextToken().toInt()
    numbers = IntArray(size) { 0 }
    repeat(size) { idx ->
        numbers[idx] = tk.nextToken().toInt()
    }

    return numbers
}

private fun dfs(start: Int, result: String) {
    if (count == 6) {
        sb.append("$result\n")
    } else {
        for (idx in start + 1 until size) {
            count++
            dfs(idx, "$result${numbers[idx]} ")
        }
    }
    count--
}