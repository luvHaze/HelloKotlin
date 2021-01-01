package Baekjoon.Grade7_String

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()

    val hashAlpha = initHash(HashMap<Char, Int>())

    string.forEach {
        var asci = it.toInt()
        if(asci >= 'a'.toInt()){
            asci -= 32
        }

        hashAlpha[asci.toChar()] = hashAlpha[asci.toChar()]!! + 1
    }

    var MAX = hashAlpha.values.max()
    var result = ""
    hashAlpha.forEach { k, v ->
        if(v == MAX) {
            result += k
        }
    }

    if(result.length == 1) {
        print(result)
    } else {
        print("?")
    }

}

fun initHash(hash: HashMap<Char, Int>): HashMap<Char, Int> {
    val A = 'A'.toInt()
    val Z = 'Z'.toInt()
    for(i in A..Z) {
        val char = i.toChar()
        hash[char] = 0
    }
    return hash
}

