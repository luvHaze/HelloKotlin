package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine()

    var setCount = 1
    val set = IntArray(10) { 1 }
    for (number in N) {
        val index = number.toString().toInt()
        when (index) {
            6 -> {
                if (set[index] == 0 && set[9] > 0) {
                    set[9] -= 1
                } else if (set[index] == 0 && set[9] == 0) {
                    addSet(set)
                    setCount++
                    set[index] -= 1
                } else {
                    set[index] -= 1
                }
            }
            9 -> {
                if (set[index] == 0 && set[6] > 0) {
                    set[6] -= 1
                } else if (set[index] == 0 && set[6] == 0) {
                    addSet(set)
                    setCount++
                    set[index] -= 1
                } else {
                    set[index] -= 1
                }
            }
            else -> {
                if (set[index] == 0) {
                    addSet(set)
                    setCount++
                    set[index] -= 1
                } else {
                    set[index] -= 1
                }
            }
        }
    }
    print(setCount)
}

private fun addSet(set: IntArray) {
    for (idx in set.indices) {
        set[idx] += 1
    }
}