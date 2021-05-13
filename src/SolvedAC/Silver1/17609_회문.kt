package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringNumber = br.readLine().toInt()

    val list = arrayListOf<String>()
    repeat(stringNumber) {
        list.add(br.readLine())
    }

    list.forEach {
        println(solution(it))
    }
}

private fun solution(string: String): Int {
    return when {
        isPalindrome(string, 0, string.length - 1) -> {
            0
        }
        isPsePalindrome(string, 0, string.length - 1) -> {
            1
        }
        else -> {
            2
        }
    }
}

private fun isPalindrome(s: String, l: Int, r: Int): Boolean {
    var left = l
    var right = r

    while (left <= right) {
        if (s[left] != s[right]) {
            return false
        }
        left++
        right--
    }
    return true
}

private fun isPsePalindrome(s: String, l: Int, r: Int): Boolean {
    var left = l
    var right = r

    while (left <= right) {
        if (s[left] != s[right]) {
            val leftRemoved = isPalindrome(s, left + 1, right)
            val rightRemoved = isPalindrome(s, left, right - 1)
            return leftRemoved || rightRemoved
        }
        left++
        right--
    }
    return true
}
