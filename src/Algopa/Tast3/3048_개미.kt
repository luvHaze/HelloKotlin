package Algopa.Tast3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

enum class Direction {
    LEFT, RIGHT
}

data class Ant(
        var name: Char,
        var dir: Direction
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val sizeGroupA = token.nextToken().toInt()
    val sizeGroupB = token.nextToken().toInt()

    val strGroupA = br.readLine()
    val strGroupB = br.readLine()

    val time = br.readLine().toInt()

    val listAnt = arrayListOf<Ant>()

    for (i in strGroupA.length - 1 downTo 0) {
        listAnt.add(Ant(strGroupA[i], Direction.RIGHT))
    }

    for (i in strGroupB.indices) {
        listAnt.add(Ant(strGroupB[i], Direction.LEFT))
    }

    var ignoreNum = -1
    for (t in 1..time) {
        for (i in 0..listAnt.size - 2) {
            if (listAnt[i].dir == Direction.RIGHT && listAnt[i + 1].dir == Direction.LEFT) {
                if (ignoreNum != i) {
                    var temp = listAnt[i]
                    listAnt[i] = listAnt[i + 1]
                    listAnt[i + 1] = temp
                    ignoreNum = i + 1
                }
            }
        }
        ignoreNum = -1
    }

    var result = ""
    listAnt.forEach {
        result += it.name
    }

    print(result)
}

