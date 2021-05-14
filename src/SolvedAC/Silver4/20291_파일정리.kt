package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val fileNumber = br.readLine().toInt()

    val extensionHash = TreeMap<String, Int>()
    repeat(fileNumber) {
        val fileName = br.readLine()
        val extension = fileName.split(".").run { this[1] }
        extensionHash[extension] = extensionHash.getOrDefault(extension, 0) + 1
    }

    extensionHash.forEach { (key, value) ->
        println("$key $value")
    }
}
