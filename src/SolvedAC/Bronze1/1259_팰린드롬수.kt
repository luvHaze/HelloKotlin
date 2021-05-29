package SolvedAC.Bronze1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numbers = arrayListOf<String>()

    while (true) {
        val string = br.readLine()

        if (string == "0") {
            break
        } else {
            numbers.add(string)
        }
    }

    numbers.forEach { number ->
        if (number.isPalen()) {
            println("yes")
        } else {
            println("no")
        }
    }

}

fun String.isPalen(): Boolean {
    var left = ""
    var right = ""
    if (this.length % 2 == 1) {
        left = this.substring(0..this.length / 2)
        right = this.substring(this.length / 2 until this.length).reversed()
    } else {
        left = this.substring(0 until this.length / 2)
        right = this.substring(this.length / 2 until this.length).reversed()
    }

    return left == right
}