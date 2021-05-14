package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val notListenNumber = token.nextToken().toInt()
    val notSeeNumber = token.nextToken().toInt()

    val nameMap = TreeMap<String, Int>()
    val nestedList = arrayListOf<String>()

    repeat(notListenNumber + notSeeNumber) {
        val name = br.readLine()

        when {
            nameMap[name] == null -> {
                nameMap[name] = 1
            }
            nameMap[name] != null -> {
                nestedList.add(name)
            }
        }
    }
    nestedList.sort()

    println(nestedList.size)
    print(nestedList.joinToString("\n"))
}