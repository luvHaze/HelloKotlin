package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var queue: LinkedList<Int> = LinkedList<Int>()
private lateinit var arr: Array<IntArray>
private var N = 0
private var M = 0
private var R = 0

fun main() {
    init()
    solution()
}

fun solution() {
    var x = 0
    var y = 0
    var row = N - 1
    var col = M - 1
    var mode = "ADD"

    while (row >= N / 2 && col >= M / 2) {
        mode = "ADD"
        down(x, y, row, mode)
        right(row, y, col, mode)
        up(row, col, x, mode)
        left(x, col, y, mode)

        rotate(R)

        mode = "FIX"
        down(x, y, row, mode)
        right(row, y, col, mode)
        up(row, col, x, mode)
        left(x, col, y, mode)

        x += 1
        y += 1
        row -= 1
        col -= 1
    }
    printArr()
}

fun rotate(times: Int) {
    repeat(times) {
        queue.addFirst(queue.removeLast())
    }
}

fun down(startRow: Int, startCol: Int, finishRow: Int, mode: String) {
    if (mode == "ADD") {
        for (idx in startRow until finishRow) {
            queue.add(arr[idx][startCol])
        }
    } else {
        for (idx in startRow until finishRow) {
            arr[idx][startCol] = queue.removeFirst()
        }
    }
}

fun right(startRow: Int, startCol: Int, finishCol: Int, mode: String) {
    if (mode == "ADD") {
        for (idx in startCol until finishCol) {
            queue.add(arr[startRow][idx])
        }
    } else {
        for (idx in startCol until finishCol) {
            arr[startRow][idx] = queue.removeFirst()
        }
    }
}

fun up(startRow: Int, startCol: Int, finishRow: Int, mode: String) {
    if (mode == "ADD") {
        for (idx in startRow downTo finishRow + 1) {
            queue.add(arr[idx][startCol])
        }
    } else {
        for (idx in startRow downTo finishRow + 1) {
            arr[idx][startCol] = queue.removeFirst()
        }
    }
}


fun left(startRow: Int, startCol: Int, finishCol: Int, mode: String) {
    if (mode == "ADD") {
        for (idx in startCol downTo finishCol + 1) {
            queue.add(arr[startRow][idx])
        }
    } else {
        for (idx in startCol downTo finishCol + 1) {
            arr[startRow][idx] = queue.removeFirst()
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tk = StringTokenizer(br.readLine())
    N = tk.nextToken().toInt()
    M = tk.nextToken().toInt()
    R = tk.nextToken().toInt()

    arr = Array(N) { IntArray(M) { 0 } }
    repeat(N) { row ->
        tk = StringTokenizer(br.readLine())
        repeat(M) { col ->
            arr[row][col] = tk.nextToken().toInt()
        }
    }
}

private fun printArr() {
    repeat(N) { row ->
        repeat(M) { col ->
            print("${arr[row][col]} ")
        }
        println()
    }
}
