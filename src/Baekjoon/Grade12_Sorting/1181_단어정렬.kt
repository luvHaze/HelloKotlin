package Baekjoon.Grade12_Sorting

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numWords = br.readLine().toInt()

    val arrWord = arrayListOf<String>()
    for (i in 1..numWords) {
        arrWord.add(br.readLine())
    }

    arrWord.sortWith(Comparator<String> { o1, o2 ->
        when {
            o1?.length!! > o2!!.length -> 1
            o1.length == o2.length -> {
                when {
                    o1 > o2 -> 1
                    o1 == o2 -> 0
                    else -> -1
                }
            }
            else -> -1
        }
    })
    arrWord.distinct().forEach {
        println(it)
    }

}