package Baekjoon.Grade6_Function

fun main() {
    val N = 10000
    val arr = BooleanArray(N)

    for (i in 1 until N) {
        var idx = solution(i)

        if (idx < N) {
            arr[idx] = true
        }
    }

    for(i in 1 until N) {
        if(!arr[i]) println(i)
    }
}

fun solution(n: Int): Int {
    var num = n
    var sum = num

    while (true) {
        if (num == 0) break
        sum += num % 10
        num /= 10
    }

    return sum
}
