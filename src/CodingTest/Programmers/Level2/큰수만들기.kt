package CodingTest.Programmers.Level2

private class MakeBigNumberSolution {

    private lateinit var numberArr: List<Int>

    fun solution(number: String, k: Int): String {
        var answer = StringBuilder()
        val resultLength = number.length - k

        numberArr = number.map {
            it.toString().toInt()
        }

        val startResult = getBestNumber(0, k)
        answer.append(startResult.first)
        var start = startResult.second + 1
        var end = numberArr.size - resultLength + answer.length

        for (i in 1 until resultLength) {
            val result = getBestNumber(start, end)
            answer.append(result.first)
            start = result.second + 1
            end = numberArr.size - resultLength + answer.length
        }

        return answer.toString()
    }

    fun getBestNumber(start: Int, end: Int): Pair<String, Int> {
        var bestNumber = numberArr[start]
        var index = start
        for (i in start..end) {
            if (bestNumber < numberArr[i]) {
                bestNumber = numberArr[i]
                index = i
            }
        }
        return Pair<String, Int>(bestNumber.toString(), index)
    }
}