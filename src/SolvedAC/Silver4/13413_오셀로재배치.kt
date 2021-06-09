package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

    val result = StringBuilder()
    repeat(case) {
        val N = br.readLine().toInt()
        val before = br.readLine().toCharArray()
        val goal = br.readLine().toCharArray()

        result.append("${getMinimumCount(before, goal, N)}\n")
    }

    print(result)
}

private fun getMinimumCount(before: CharArray, goal: CharArray, length: Int): Int {
    var count = 0
    for (idx in 0 until length) {
        if (before[idx] != goal[idx]) {
            val swapPosition = findSwapPosition(before, goal, idx)
            if (swapPosition != idx) {
                swap(before, idx, swapPosition)
                count++
            }
        }
    }
    for (idx in 0 until length) {
        if (before[idx] != goal[idx]) {
            before[idx] = goal[idx]
            count++
        }
    }

    return count
}

private fun findSwapPosition(before: CharArray, goal: CharArray, idx: Int): Int {
    for (i in idx + 1 until before.size) {
        if (before[idx] == goal[i] && before[i] == goal[idx]) return i
    }
    return idx
}

private fun checkSwapIsBest(before: CharArray, goal: CharArray, idx: Int): Boolean {
    return before[idx] != goal[idx]
            && before[idx + 1] == goal[idx]
            && goal[idx + 1] == before[idx]
}

private fun swap(arr: CharArray, from: Int, to: Int) {
    val temp = arr[from]
    arr[from] = arr[to]
    arr[to] = temp
}