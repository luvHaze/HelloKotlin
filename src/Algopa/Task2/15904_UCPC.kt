package Algopa.Task2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var string = br.readLine()

    if(checkUCPC(string)) {
        print("I love UCPC")
    } else {
        print("I hate UCPC")
    }
}

fun checkUCPC(str: String): Boolean {
    var isUCPC = false
    var UCPC = "UCPC"
    var indexUCPC = 0

    for(i in str.indices) {
        var char = str[i]
        when(char) {
            'U' -> {
                if(UCPC[indexUCPC] == 'U') indexUCPC ++
            }

            'C' -> {
                if(UCPC[indexUCPC] == 'C') indexUCPC ++
            }

            'P' -> {
                if(UCPC[indexUCPC] == 'P') indexUCPC ++
            }

        }

        if(indexUCPC == 4) {
            isUCPC = true
            break
        }
    }

    return isUCPC
}