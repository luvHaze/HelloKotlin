package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private val br = BufferedReader(InputStreamReader(System.`in`))
private lateinit var arrA: Array<IntArray>
private lateinit var arrB: Array<IntArray>
private var ROW = 0
private var COL = 0

fun main() {
    init()

    var count = 0
    for(row in 0 until ROW - 2) {
        for(col in 0 until COL - 2) {
            if(arrA[row][col] != arrB[row][col]) {
                makrArr(row, col)
                count++
            }
        }
    }

    if(!isSameArr()) {
        print(-1)
    } else {
        print(count)
    }
}

private fun isSameArr(): Boolean {
    repeat(ROW) { row ->
        repeat(COL) { col ->
            if(arrA[row][col] != arrB[row][col]) return false
        }
    }
    return true
}


private fun makrArr(sRow: Int, sCol: Int) {
    for(row in sRow until sRow+3) {
        for(col in sCol until sCol+3) {
            if(arrA[row][col] == 1) arrA[row][col] = 0
            else arrA[row][col] = 1
        }
    }
}


private fun init() {
    val tk = StringTokenizer(br.readLine())
    ROW = tk.nextToken().toInt()
    COL = tk.nextToken().toInt()

    arrA = makeArr()
    arrB = makeArr()
}

private fun makeArr(): Array<IntArray> {
    val arr = Array(ROW) { IntArray(COL) { 0 } }
    repeat(ROW) { row ->
        val rowString = br.readLine()
        rowString.forEachIndexed { col, char ->
            arr[row][col] = char.toString().toInt()
        }
    }

    return arr
}