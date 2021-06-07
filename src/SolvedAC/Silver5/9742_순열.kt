package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var visitedArr: BooleanArray
private lateinit var tempArr: CharArray
private lateinit var _case: Case
private var combiCount = 0
private var count = 0
private var result = ""

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cases = arrayListOf<Case>()

    while (true) {
        val line = br.readLine()
        if (line == null || line == "") break

        val tk = StringTokenizer(line)
        val string = tk.nextToken()
        val position = tk.nextToken().toInt()

        cases.add(Case(string, position))
    }

    for (case in cases) {
        visitedArr = BooleanArray(case.string.length) { false }
        tempArr = CharArray(case.string.length) { ' ' }
        result = ""
        combiCount = 0
        _case = case
        dfs(0)
        if(result != "") {
            println("${case.string} ${case.position} = $result")
        } else {
            println("${case.string} ${case.position} = No permutation")
        }
    }
}

private fun dfs(count: Int) {
    if (count == _case.string.length) {
        combiCount++
        if(combiCount == _case.position) {
            result = tempArr.joinToString("")
        }
        return
    }

    for (idx in _case.string.indices) {
        if (visitedArr[idx]) continue
        visitedArr[idx] = true
        tempArr[count] = _case.string[idx]
        dfs(count + 1)
        visitedArr[idx] = false
    }
}

private class Case(
    val string: String,
    val position: Int
)