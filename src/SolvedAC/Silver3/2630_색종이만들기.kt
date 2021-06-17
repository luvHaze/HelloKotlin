package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var paper: Array<BooleanArray>
private var blacks = 0
private var whites = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    paper = Array(N) { BooleanArray(N) { false } }
    for (row in 0 until N) {
        val tk = StringTokenizer(br.readLine())
        for (col in 0 until N) {
            if (tk.nextToken() == "1") {
                paper[row][col] = true
            }
        }
    }

    dfs(0, 0, N)

    println(whites)
    print(blacks)
}

private fun dfs(row: Int, col: Int, N: Int){
    if(checkPaper(row, col, N)) {
        if(paper[row][col]) blacks++
        else whites++
        return
    } else {
        val halfSize = N / 2
        dfs(row, col, halfSize)
        dfs(row + halfSize, col, halfSize)
        dfs(row, col + halfSize, halfSize)
        dfs(row + halfSize, col + halfSize, halfSize)
    }
}

private fun checkPaper(row: Int, col: Int, N: Int): Boolean {
    val firstPaper = paper[row][col]
    for(r in row until row + N) {
        for(c in col until col + N) {
            if(paper[r][c] != firstPaper) return false
        }
    }

    return true
}
