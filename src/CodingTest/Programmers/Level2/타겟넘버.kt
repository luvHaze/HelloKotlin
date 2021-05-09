package CodingTest.Programmers.Level2

private class TargetNumberSolution {

    private var answer: Int = 0
    private var target: Int = 0
    private lateinit var numbers: IntArray

    fun solution(numbers: IntArray, target: Int): Int {
        this.target = target
        this.numbers = numbers

        dfs(0, 0)

        return answer
    }

    private fun dfs(sum: Int, idx: Int) {
        if (idx < numbers.size - 1) {
            dfs(sum + numbers[idx], idx + 1)
            dfs(sum - numbers[idx], idx + 1)
        } else {
            if (sum + numbers[idx] == target) answer++
            if (sum - numbers[idx] == target) answer++
        }
    }
}