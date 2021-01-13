package Baekjoon.Grade12_Sorting

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

data class Statics(
        var data: MutableList<Int>
) {
    fun getAverage(): Double {
        return data.average()
    }

    fun getMiddleValue(): Int {
        data.sort()
        return data[data.size / 2]
    }

    fun getManyValue(): Int {
        val hashMap = hashMapOf<Int, Int>()
        data.forEach {
            val value = hashMap.getOrDefault(it,0) +1
            hashMap.put(it, value)
        }

        val max = hashMap.values.max()
        var filterKeys = hashMap.filterKeys {
            hashMap[it] == max
        }.keys.sorted()

        if(filterKeys.size != 1) {
            return filterKeys[1]
        } else {
            return  filterKeys.first()
        }
    }

    fun getDistance(): Int {
        return data.max()!! - data.min()!!
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val tempList = mutableListOf<Int>()
    for (i in 0 until N) {
        tempList.add(br.readLine().toInt())
    }

    val staticObject = Statics(tempList)

    println(staticObject.getAverage().roundToInt())
    println(staticObject.getMiddleValue())
    println(staticObject.getManyValue())
    println(staticObject.getDistance())
}