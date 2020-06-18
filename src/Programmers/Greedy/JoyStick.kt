package Programmers.Greedy

// * 글자의 개수
// * 어떨때 커서를 클릭하는지
//    - 문자 자리를 옮길때
//    - 알파벳을 컨트롤 할때
// * 어떨때 거꾸로 이동을 할지
//   - 해당 문자가 A랑 가까운지 Z와 가까운지를 비교한다.

fun main() {
    var name = "JEROEN"
    var answer = 0
    var nameSize = name.length-1
    val A = 65
    val Z = 90

    name.forEach {
        val alpha = it.toInt()

        when(it.toInt()){
            in A..A+12 ->{
                if(alpha!=A) {
                    answer++
                    answer += alpha-A
                }
            }
            in A+13..Z ->{
                answer += Z-alpha
                answer++
            }
        }
    }

    println(answer)



}