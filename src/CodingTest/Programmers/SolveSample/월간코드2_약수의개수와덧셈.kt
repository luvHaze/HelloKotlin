package CodingTest.Programmers.SolveSample

private class DivisorPlusSolution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0

        for(number in left..right) {
            if(getDivisorCount(number) % 2 == 0) {
                answer += number
            } else {
                answer -= number
            }
        }

        return answer
    }

    fun getDivisorCount(number: Int): Int {
        var count = 0
        var divisor = 1
        while(divisor <= number / 2) {
            if(number % divisor == 0) {
                count++
            }
            divisor++
        }

        return count + 1
    }
}