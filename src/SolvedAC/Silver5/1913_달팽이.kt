package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val target = br.readLine().toInt()
    var targetRow = 0
    var targetCol = 0

    val map = Array(N) { IntArray(N) { 0 } }
    var row = N / 2
    var col = N / 2
    map[row][col] = 1

    var times = 0
    var number = 2
    while (number <= N * N) {
        // UP
        times += 1
        for (idx in 1..times) {
            row--
            if(number.isTarget(target)) {
                targetRow = row
                targetCol = col
            }
            if (row < 0) break
            map[row][col] = number
            number++
        }
        if (row == -1 && col == 0) break

        //RIGHT
        repeat(times) {
            col++
            if(number.isTarget(target)) {
                targetRow = row
                targetCol = col
            }
            map[row][col] = number
            number++
        }

        //DOWN
        times += 1
        repeat(times) {
            row++
            if(number.isTarget(target)) {
                targetRow = row
                targetCol = col
            }
            map[row][col] = number
            number++
        }

        //LEFT
        repeat(times) {
            col--
            if(number.isTarget(target)) {
                targetRow = row
                targetCol = col
            }
            map[row][col] = number
            number++
        }
    }

    printMap(map)
    print("${targetRow + 1} ${targetCol + 1}")
}

private fun Int.isTarget(target: Int): Boolean {
    return this == target
}

private fun printMap(map: Array<IntArray>) {
    for(row in map) {
        for(col in row) {
            print("$col ")
        }
        println()
    }
}
