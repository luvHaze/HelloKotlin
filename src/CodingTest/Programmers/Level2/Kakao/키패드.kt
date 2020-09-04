package CodingTest.Programmers.Level2.Kakao


lateinit var keypadHash: HashMap<Char, ArrayList<Int>>
val ROW = 0
val COL = 1

fun solution(numbers: IntArray, hand: String): String {
    var answer = ""
    var leftThumb = ArrayList<Int>(2)
    var rightThumb = ArrayList<Int>(2)

    initHash()
    leftThumb = keypadHash['*']!!
    rightThumb = keypadHash['#']!!

    numbers.forEach {
        val key = (it + 48).toChar()
        when (key) {

            '1', '4', '7' -> {
                answer += "L"
                leftThumb = keypadHash[key]!!
            }
            '3', '6', '9' -> {
                answer += "R"
                rightThumb = keypadHash[key]!!
            }
            '2', '5', '8', '0' -> {
                var stdKey = keypadHash[key]!!
                var leftDistance = Math.abs(stdKey[ROW] - leftThumb[ROW]) +
                        Math.abs(stdKey[COL] - leftThumb[COL])
                var rightDistance = Math.abs(stdKey[ROW] - rightThumb[ROW]) +
                        Math.abs(stdKey[COL] - rightThumb[COL])
                // 왼손의 좌표와 눌러야할 번호의 좌표의 거리를 행과 열의 절대값을 더해 구한뒤
                // 왼손거리가 가까우면 왼손으로
                // 오른선이면 오른손으로 누른다
                // 거리가 같으면 사용자의 주력 손으로 누른다.
                if (leftDistance < rightDistance) {
                    answer += "L"
                    leftThumb = stdKey
                } else if (leftDistance > rightDistance) {
                    answer += "R"
                    rightThumb = stdKey
                } else {
                    if (hand == "right") {
                        answer += "R"
                        rightThumb = stdKey
                    } else {
                        answer += "L"
                        leftThumb = stdKey
                    }
                }
            }
        }
    }

    return answer
}

fun initHash() {

    keypadHash = hashMapOf<Char, ArrayList<Int>>(
            '1' to arrayListOf<Int>(0, 0),
            '2' to arrayListOf<Int>(0, 1),
            '3' to arrayListOf<Int>(0, 2),
            '4' to arrayListOf<Int>(1, 0),
            '5' to arrayListOf<Int>(1, 1),
            '6' to arrayListOf<Int>(1, 2),
            '7' to arrayListOf<Int>(2, 0),
            '8' to arrayListOf<Int>(2, 1),
            '9' to arrayListOf<Int>(2, 2),
            '*' to arrayListOf<Int>(3, 0),
            '0' to arrayListOf<Int>(3, 1),
            '#' to arrayListOf<Int>(3, 2)
    )
}
