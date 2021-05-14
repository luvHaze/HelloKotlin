package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringNumber = br.readLine().toInt()
    val condition = """[A-F]{0,1}(A+F+C+)[A-F]{0,1}""".toRegex()

    repeat(stringNumber) {
        val string = br.readLine()
        if (condition.matches(string)) {
            println("Infected!")
        } else {
            println("Good")
        }
    }
}