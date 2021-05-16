package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stdString = br.readLine()
    val findString = br.readLine().toList()

    val filteredString= stdString.filter { it !in '0'..'9' }
    val answer = filteredString.contains(findString.joinToString(""))
    if(answer) {
        print(1)
    } else {
        print(0)
    }
}