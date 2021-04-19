package SolvedAC.Bronze1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val humans = mutableListOf<Int>()
    repeat(9) {
        humans.add(br.readLine().toInt())
    }

    val sum = humans.sum()
    val size = humans.size
    var isFound = false

    for (num1 in 0 until humans.size - 1) {
        for (num2 in num1 + 1 until humans.size) {
            if (sum - (humans[num1] + humans[num2]) == 100) {
                humans[num1] = 0
                humans[num2] = 0
                isFound = true
                break
            }
        }
        if (isFound) break
    }

    val result = humans.filter { it != 0 }
        .sorted()
        .map { println(it) }
}
