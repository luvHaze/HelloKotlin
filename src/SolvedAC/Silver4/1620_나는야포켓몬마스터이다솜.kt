package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())

    val N = tk.nextToken().toInt()
    val M = tk.nextToken().toInt()

    val pocketDex = HashMap<String, Int>()
    val pocketmons = Array<String>(N + 1) { "" }
    repeat(N) { idx ->
        val pocketmon = br.readLine()
        pocketDex[pocketmon] = idx + 1
        pocketmons[idx + 1] = pocketmon
    }

    val answer = StringBuilder()
    repeat(M) {
        val findKeyword = br.readLine()
        if(pocketDex[findKeyword] == null) {
            val idx = findKeyword.toInt()
            answer.append("${pocketmons[idx]}\n")
        } else {
            answer.append("${pocketDex[findKeyword]}\n")
        }
    }

    print(answer)
}