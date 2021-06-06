package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private const val COW_NUMBER = 10

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val cows = Array<String>(COW_NUMBER + 1) { "" }

    val records = arrayListOf<Record>()
    repeat(N) {
        val tk = StringTokenizer(br.readLine())
        val cow = tk.nextToken().toInt()
        val position = tk.nextToken()

        records.add(Record(cow, position))
    }

    var moveCount = 0
    for (record in records) {
        if(cows[record.cow] != "") {
            if (cows[record.cow] != record.position) moveCount++
        }
        cows[record.cow] = record.position
    }

    print(moveCount)
}

private class Record(
    val cow: Int,
    val position: String
)