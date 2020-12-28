package Algopa.Tast3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())

    val PEOPLE = token.nextToken().toInt()
    val END_SCORE = token.nextToken().toInt()
    val UNIT = token.nextToken().toInt()

    var GAMESET = false
    var index = 1
    var result = 0

    val gameHash = HashMap<Int, Int?>()
    for (i in 1..PEOPLE) {
        gameHash[i] = 0
    }
    gameHash[index] = 1

    while (!GAMESET) {

        when (gameHash[index]!! % 2) {
            0 -> {
                index -= UNIT
                if(index < 1) index +=PEOPLE
            }
            1 -> {
                index += UNIT
                if(index > PEOPLE) index -= PEOPLE
            }
        }
        gameHash[index] = gameHash[index]?.plus(1)
        result++

        if (gameHash[index]!! >= END_SCORE) {
           GAMESET = true
        }

    }

    print(result)

}