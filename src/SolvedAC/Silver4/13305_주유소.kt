package SolvedAC.Silver4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.cos

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val distances = arrayListOf<Long>()
    val cities = arrayListOf<Long>()
    var tk = StringTokenizer(br.readLine())
    repeat(N - 1) {
        distances.add(tk.nextToken().toLong())
    }

    tk = StringTokenizer(br.readLine())
    repeat(N) {
        cities.add(tk.nextToken().toLong())
    }

    var allCost: Long = cities[0] * distances[0]
    var minCost = cities[0]

    for(idx in 1 until distances.size) {
        if(cities[idx] <= minCost) minCost = cities[idx]
        allCost += minCost * distances[idx]
    }

    print(allCost)
}