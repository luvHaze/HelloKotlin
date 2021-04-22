package SolvedAC.Gold4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val string = br.readLine()
    val removeString = br.readLine()

    val sb= StringBuilder()
    string.forEach { char ->
        if(!removeString.contains(char)) {
            sb.append(char)
        }
    }

    if(sb.isEmpty()) {
        print("FRULA")
    } else {
        print(sb)
    }
}
