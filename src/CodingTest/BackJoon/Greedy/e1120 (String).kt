package CodingTest.BackJoon.Greedy

import java.util.*

/*
*       짧은 문자열 A의 앞뒤에는 문자를 붙일 수 있기에
*       A와 B의 차이의 관건은 A를 B의 어느 문자부터 비교를 해봐야 하는지 이다.
*       1. B를 A크기만큼 슬라이스 해서 strTemp에 넣어준다.
*       2. strTemp와 A를 비교 하며 두 문자열간 문자 차이를 카운트
*       3. 카운트가 정답보다 작으면(i가 0일때는 처음) 정답에 카운트를 저장
*/

fun main() {
    val sc = Scanner(System.`in`)
    val strA = sc.next()
    val strB = sc.next()
    val iGapLength = strB.length-strA.length
    var answer = 0

    for(i in 0 .. iGapLength){
        var iGapCounter = 0
        val strTemp=strB.slice(i until i+strA.length)

        for(x in strA.indices){

            if(strA[x]!=strTemp[x]){
                iGapCounter++
            }
        }
        if(answer>=iGapCounter || i == 0) answer=iGapCounter
    }

    print(answer)
}