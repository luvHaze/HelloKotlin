package Algopa.Task1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var number = br.readLine().toLong()

    var round = true
    var standard = 10

    while (number > standard) {

        if (number % standard >= standard / 2) {
            number -= number % standard
            number += standard
        } else {
            number -= number % standard
        }

        standard *= 10
    }

    print(number)

}