package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader

private const val DASOM = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val peoples = IntArray(N) { 0 }
    repeat(N) { idx ->
        peoples[idx] = br.readLine().toInt()
    }

    var boughtPeople = 0
    while(true){
        val maxIdx = getMaxIndex(peoples)
        if(maxIdx == DASOM) break

        peoples[maxIdx] -= 1
        peoples[DASOM] += 1
        boughtPeople++
    }

    print(boughtPeople)
}

fun getMaxIndex(peoples: IntArray): Int {
    var maxValue = Int.MIN_VALUE
    var maxIdx = -1
    for(idx in peoples.indices) {
        if(maxValue <= peoples[idx]) {
            maxValue = peoples[idx]
            maxIdx = idx
        }
    }

    return maxIdx
}