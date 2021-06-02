package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

    val results = arrayListOf<Pair<Int, Int>>()
    repeat(case) {
        val string = br.readLine()
        val K = br.readLine().toInt()

        val hash = makeHashTable(string)
        var minLength = Int.MAX_VALUE
        var maxLength = Int.MIN_VALUE
        string.forEachIndexed { idx, char ->
            if (hash[char]!! >= K && idx <= string.length - 1) {
                var kCount = 1
                var length = 1
                var lIdx = idx
                while(kCount != K) {
                    length++
                    lIdx++
                    if(lIdx > string.length - 1) break
                    if(string[lIdx] == char) {
                        kCount++
                    }
                }

                if (length < minLength && kCount == K) {
                    minLength = length
                }
                if (length > maxLength && kCount == K) {
                    maxLength = length
                }
            }
        }
        results.add(Pair(minLength, maxLength))
    }

    results.forEach { result ->
        if(result.first != Int.MAX_VALUE && result.second != Int.MIN_VALUE) {
            println("${result.first} ${result.second}")
        } else {
            println(-1)
        }
    }
}

fun makeHashTable(string: String): HashMap<Char, Int> {
    val hashMap = HashMap<Char, Int>()

    string.forEach { char ->
        hashMap[char] = hashMap.getOrDefault(char, 0) + 1
    }

    return hashMap
}