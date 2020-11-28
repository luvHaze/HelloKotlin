package Algopa.Task1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    val COUNTRY_COUNT = token.nextToken().toInt()
    val COUNTRY = token.nextToken().toInt()

    var rankHash = HashMap<Int, Double>()

    for (i in 1..COUNTRY_COUNT) {
        val iterator = StringTokenizer(br.readLine())
        val COUNTRY_NUM = iterator.nextToken().toInt()
        val GOLD = iterator.nextToken().toDouble() * 1000001
        val SILVER = iterator.nextToken().toDouble() * 1.1
        val BRONZE = iterator.nextToken().toDouble() * 0.000001

        rankHash[COUNTRY_NUM] = (GOLD + SILVER + BRONZE)
    }

    print(findRank(COUNTRY, rankHash))
}


fun findRank(country: Int, countryHash: HashMap<Int, Double>): Int {

    var listRank = countryHash.values.sortedDescending()
    var ranking = 1

    var index = 0
    while (true) {
        if (countryHash[country] == listRank[index]) {
            break
        } else {
            ranking += 1
        }

        index += 1
    }

    return ranking
}