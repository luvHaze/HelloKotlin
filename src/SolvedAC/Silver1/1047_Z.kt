package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.pow

private var N = 0
private var R = 0
private var C = 0
private val SIZE by lazy { pow(2, N) }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())

    N = tk.nextToken().toInt()
    R = tk.nextToken().toInt()
    C = tk.nextToken().toInt()

    println(dfs(0, 0, SIZE))
}

private fun dfs(row: Int, col: Int, size: Int): Int {
    if (size == 1) {
        return 0
    }

    return when {
        R < row + size.half() && C < col + size.half() -> {
            dfs(row, col, size.half())
        }
        R < row + size.half() && C < col + size -> {
            dfs(row, col+ size.half(), size.half()) + pow(size.half(), 2)
        }
        R < row + size && C < col + size.half() -> {
            dfs(row + size.half(), col, size.half()) + pow(size.half(), 2) * 2
        }
        else -> {
            dfs(row + size.half(), col + size.half(), size.half()) + pow(size.half(), 2) * 3
        }
    }
}

private fun Int.half(): Int {
    return this / 2
}

private fun pow(target: Int, times: Int): Int {
    return Math.pow(target.toDouble(), times.toDouble()).toInt()
}

