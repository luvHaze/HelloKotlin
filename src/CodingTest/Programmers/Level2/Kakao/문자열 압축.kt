package CodingTest.Programmers.Level2.Kakao

fun solution2(s: String): Int {
    var answer = s.length

    for (i in 1..s.length / 2) {
        var start = i
        var end = start + i
        var count = 0
        var abs = s.length

        // 첫번째 블럭 확보
        var comp = s.substring(0, i)
        while (end <= s.length) {
            // 비교 블럭과 다음 블럭을 비교하여 같으면 카운트
            if (comp.equals(s.substring(start, end))) count = count + 1
            // 다르면
            else {
                // 카운트가 0이 아니면 압축
                if (count > 0) abs = abs - count * i + (count + 1).toString().length
                // 다음 블럭을 비교 블럭으로 한다
                comp = s.substring(start, end)
                count = 0
            }
            // 다음 블럭
            start = end
            end = start + i
        }
        // 카운트가 0이 아니면 압축
        if (count > 0) abs = abs - count * i + (count + 1).toString().length
        // i개 블럭의 압축결과가 최소값인지 확인
        answer = if (abs < answer) abs else answer
    }
    return answer
}
