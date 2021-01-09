package Baekjoon.Grage10_Recursive

import java.io.BufferedReader
import java.io.InputStreamReader

private var result = 0
private var str = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()

    // number -> 원판의 개수
    hanoi(number, 1, 2, 3)
    println(result)
    println(str)
}

/*
*   from  -> 출발 원판
*   by -> 이용하는 원판
*   to -> 도착하는 원판
 */
fun hanoi(n: Int, from: Int, by: Int, to: Int) {
    result += 1

    // 원판이 하나 남았을 경우
    if (n == 1) {
        str.append("$from $to\n")
        return
    } else {
        // 원판 1에서 원판 2 넘기기
        hanoi(n - 1, from, to, by)
        str.append("$from $to\n") // 원판1에서 마지막 원판 3으로 옮기
        // 원판2에서 원판 3으로 넘기기
        hanoi(n - 1, by, from, to)
    }
}