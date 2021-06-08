package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

    val answer = StringBuilder()
    repeat(case) {
        val treeNumber = br.readLine().toInt()
        val tk = StringTokenizer(br.readLine())
        val trees = IntArray(treeNumber) { 0 }
        repeat(treeNumber) { idx ->
            trees[idx] = tk.nextToken().toInt()
        }

        val sortedArr = sortMinimum(trees, treeNumber)
        val min = getMinimumValue(sortedArr, treeNumber)
        answer.append("$min\n")
    }

    println(answer)
}

private fun sortMinimum(trees: IntArray, treeNumber: Int): IntArray {
    val result = IntArray(treeNumber) { 0 }
    var left = 0
    var right = treeNumber - 1
    var direction = "LEFT"

    trees.sort()
    for (tree in trees) {
        when (direction) {
            "LEFT" -> {
                result[left] = tree
                direction = "RIGHT"
                left++
            }
            "RIGHT" -> {
                result[right] = tree
                direction = "LEFT"
                right--
            }
        }
    }
    return result
}

private fun getMinimumValue(sortedArr: IntArray, treeNumber: Int): Int {
    var max = Int.MIN_VALUE
    for(idx in 0 until treeNumber - 1) {
        val diff = abs(sortedArr[idx] - sortedArr[idx + 1])
        if(diff > max) max = diff
    }

    return max
}