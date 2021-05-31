package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())
    val N = tk.nextToken().toInt()
    val M = tk.nextToken().toInt()

    val dnaList = arrayListOf<String>()
    repeat(N) {
        dnaList.add(br.readLine())
    }

    var minDiff = 0
    var minDna = ""
    repeat(M) { idx ->
        val charMap = TreeMap<Char, Int>()
        dnaList.forEach { dna ->
            charMap[dna[idx]] = charMap.getOrDefault(dna[idx], 0) + 1
        }
        var maxChar = ' '
        var maxCount = 0
        charMap.forEach { char, count ->
            if (count > maxCount) {
                maxCount = count
                maxChar = char
            }
        }
        minDiff += N - maxCount
        minDna += maxChar
    }

    println(minDna)
    print(minDiff)
}
