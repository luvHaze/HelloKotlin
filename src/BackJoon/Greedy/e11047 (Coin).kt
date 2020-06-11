package BackJoon.Greedy

import java.util.*

fun main() {
    var input = Scanner(System.`in`)
    var N = input.nextInt()
    var K = input.nextInt()
    var list = arrayListOf<Int>()
    var answer = 0

    for (item in 1..N) {
        list.add(input.nextInt())
    }
    list.sortDescending()

    for (i in 0..list.size - 1) {
        answer += K / list[i]
        K %= list[i]
    }
    print(answer)
}

/*
*        * 런타임 에러의 원인 -> readLine() 에서 Scanner로 해주니 해결됐다.
*        * 코틀린은 다른언어에 비해서 실행시간이 길다고 느꼈다.
*
*
*
*
*
 */