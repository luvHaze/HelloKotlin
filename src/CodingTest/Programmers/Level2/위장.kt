package CodingTest.Programmers.Level2


// 컬렉션을 좀더 익숙해 져야
// 경우의 수 공식 몰라서 개1고생 했다
fun solution(clothes: Array<Array<String>>): Int {
    var answer = 1
    var values = clothes.groupBy { it[1] }.values.map { it.size }

    for (i in values.indices) {
        answer *= values[i] + 1
    }

    // -1은 모두 다 안입었을때를 가정
    return answer - 1
}
