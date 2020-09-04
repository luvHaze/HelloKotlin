package CodingTest.BackJoon.Greedy

import java.util.*

/*
*       잃어버린 괄호문제
*       이 문제어서 최소값을 만들기 위해선 +를 -로 묶어주는것이 Point다
*       split으로 `-` 를 기준으로 배열로 나눠주면 그 배열은
*       -가 붙은 녀석들 끼리 묶이게 되는것이고 그 안의 값을 ex) 40+50
*       다시 split으로 `+`으로 배열로 나눈뒤 그 배열의 값을을 모두 정수로 읽어 합한다.
*
*       그렇게 과정을 거치면 처음 배열은 가공이 되고
*       배열을 참조해서 결과값을 구한다
*       (문제에서 첫번째는 무조건 숫자라고 했기에 -를 곱해서 양수로 만들어준다.)
 */

fun main() {
    val sc = Scanner(System.`in`)
    val sliceExp = sc.next().split("-")
    var answer = 0

    for (index in sliceExp.indices) {
        var iTemp = changeToNum(sliceExp[index])
        if (index == 0) iTemp *= -1
        answer += iTemp
    }
    print(answer)
}

fun changeToNum(str: String): Int {
    val splitList = str.split("+")
    var result = 0

    splitList.forEach {
        result += it.toInt()
    }
    return result * -1
}