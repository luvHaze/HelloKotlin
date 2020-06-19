package Programmers.Level1

// * 글자의 개수
// * 어떨때 커서를 클릭하는지
//    - 문자 자리를 옮길때
//    - 알파벳을 컨트롤 할때
// * 최소이동의 종류
//   - 알파벳 최소이동
//      ->
//   - 자리수 최소이동

fun main() {
    var name = "JAZ"

    var answer = 0
    var answerReverse = 1
    var nameSize = name.length

    val A = 65
    val Z = 90

    for (i in 0 until nameSize) {

        val alp = name[i].toInt()

        when (alp) {
            in A..A + 12 -> {
                if (alp != A) answer += alp - A
            }
            in A + 13..Z -> answer += Z - alp
        }
        answer++
    }

    for (i in nameSize until 0) {

        val alp = name[i].toInt()

        when (alp) {
            in A..A + 12 -> {
                if (alp != A) answerReverse += alp - A
            }
            in A + 13..Z -> answerReverse += Z - alp
        }
        answerReverse++
    }

}

