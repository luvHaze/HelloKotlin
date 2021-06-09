package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader

private var N = 0
private var count = 0
private lateinit var current: CharArray
private lateinit var target: CharArray

fun main() {
    init()
    val currentA = current.copyOf()
    turnOn(current, 0)
    val currentB = current

    var answer = Int.MAX_VALUE
    var countA = 0
    var countB = 1
    for (idx in 1 until N) {
        if (currentA[idx - 1] != target[idx - 1]) {
            turnOn(currentA, idx)
            countA++
        }
        if (currentB[idx - 1] != target[idx - 1]) {
            turnOn(currentB, idx)
            countB++
        }

        if (isSame(currentA, target)) {
            if (answer > countA) answer = countA
        }

        if (isSame(currentB, target)) {
            if (answer > countB) answer = countB
        }
    }

    if (answer == Int.MAX_VALUE) {
        print(-1)
    } else {
        print(answer)
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()

    current = br.readLine().toCharArray()
    target = br.readLine().toCharArray()
}

private fun turnOn(arr: CharArray, idx: Int) {
    for (i in idx - 1..idx + 1) {
        if (i < 0 || i > N - 1) continue
        if (arr[i] == '1') arr[i] = '0'
        else arr[i] = '1'
    }
}

private fun isSame(from: CharArray, goal: CharArray): Boolean {
    return from.contentEquals(goal)
}