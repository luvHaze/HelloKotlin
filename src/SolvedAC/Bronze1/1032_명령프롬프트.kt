package SolvedAC.Bronze1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val fileNumber = br.readLine().toInt()

    val files = arrayListOf<String>()
    repeat(fileNumber) {
        files.add(br.readLine())
    }

    var answer = files[0]
    for (i in 1 until files.size) {
        answer = compareFileName(answer, files[i])
    }

    print(answer)
}

fun compareFileName(stdFile: String, compareFile: String): String {
    var result = ""
    for (i in stdFile.indices) {
        if (stdFile[i] == compareFile[i]) {
            result += stdFile[i]
        } else {
            result += "?"
        }
    }

    return result
}