package Programmers.Level2.Kakao


/* 재귀에 대해서 다시헌번 생각하게 된 함수
*  문제를 볼때 정말 꼼꼼하게 읽고 천천히 해보는것이 중요하다
*
*/


fun solution(p: String): String {

    return seperate(p)
}

fun seperate(string: String): String {

    if (string.isEmpty()) return ""

    var u = ""
    var v = ""
    var leftCounter = 0
    var rightCounter = 0
    var result = ""

    for (char in string) {

        if (leftCounter == rightCounter && leftCounter != 0) {
            v += char
        } else {

            if (char == '(') {
                leftCounter++
                u += '('
            } else if (char == ')') {
                rightCounter++
                u += ')'
            }
        }
    }

    if (isRightString(u)) {
        result = u + seperate(v)
        return result
    } else {

        var temp = ""

        temp += '('
        temp += seperate(v)
        temp += ')'

        for (i in 1 until u.length - 1) {

            if (u[i] == '(') temp += ')'
            else if (u[i] == ')') temp += '('
        }

        return temp
    }

}

fun isRightString(string: String): Boolean {
    var checker = 0

    for (char in string) {
        if (char == '(') checker++
        else if (char == ')') checker--

        if (checker < 0) return false
    }

    return true
}