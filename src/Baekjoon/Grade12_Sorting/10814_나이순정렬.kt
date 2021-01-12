package Baekjoon.Grade12_Sorting

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.Comparator

data class User(
        var age: Int,
        var name: String,
        var joinDate: Int
)


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numUser = br.readLine().toInt()

    var arrUser = arrayListOf<User>()
    for (i in 1..numUser) {
        val token = StringTokenizer(br.readLine())
        arrUser.add(User(
                age = token.nextToken().toInt(),
                name = token.nextToken(),
                joinDate = i
        )
        )
    }

    arrUser.sortWith(Comparator<User> { o1, o2 ->
        when {
            o1.age > o2.age -> 1
            o1.age == o2.age -> {
                when{
                    o1.joinDate > o2.joinDate -> 1
                    o1.joinDate == o2.joinDate -> 0
                    else -> -1
                }
            }
            else -> -1
        }

    })

    arrUser.forEach {
        println("${it.age} ${it.name}")
    }

}