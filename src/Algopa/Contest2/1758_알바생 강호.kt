package Algopa.Contest2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var number = br.readLine().toInt()

    var arrPeople = ArrayList<Int>()
    for(i in 1..number) {
        arrPeople.add(br.readLine().toInt())
    }

    var sortedArr = arrPeople.sortedDescending()
    var result: Long = 0L
    for(i in sortedArr.indices) {
        if(sortedArr[i] - i <= 0)
            break

        result += sortedArr[i] - i
    }

    print(result)
}