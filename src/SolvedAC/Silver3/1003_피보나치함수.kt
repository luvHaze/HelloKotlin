package SolvedAC.Silver3

import java.io.BufferedReader
import java.io.InputStreamReader

private var fibo: IntArray = IntArray(100) { -1 }
private var zArr = IntArray(100) { -1 }
private var oArr = IntArray(100) { -1 }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

    var result = ""
    repeat(case) {
        val number= br.readLine().toInt()
        dfs(number)
        result += "${zArr[number]} ${oArr[number]}\n"
    }
    print(result)
}

private fun dfs(number: Int) {
    when (number) {
        0 -> {
            zArr[number] = 1
            oArr[number] = 0
            return
        }
        1 -> {
            zArr[number] = 0
            oArr[number] = 1
            return
        }
        else -> {
            if(zArr[number] <= 0) {
                dfs(number - 1)
                dfs(number -2)
                zArr[number] = zArr[number - 1] + zArr[number - 2]
                oArr[number] = oArr[number - 1] + oArr[number - 2]
                return
            }
        }
    }
}

