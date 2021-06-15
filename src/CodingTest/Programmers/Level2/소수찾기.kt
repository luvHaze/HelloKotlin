package CodingTest.Programmers.Level2

private class FindPrimeSolution {
    private var LENGTH = 0
    private var primes = mutableSetOf<Int>()
    private lateinit var combi: CharArray
    private lateinit var numbers: CharArray
    private lateinit var visited: BooleanArray

    fun solution(num: String): Int {
        var answer = 0
        initial(num)

        for (target in 1..LENGTH) {
            findCombi(target, 0)
        }

        return primes.size
    }

    private fun findCombi(targetLength: Int, curIdx: Int) {
        if (targetLength == curIdx) {
            val combiNumber = combi.joinToString("").trim().toInt()
            if (isPrime(combiNumber)) primes.add(combiNumber)
            return
        }

        for (idx in 0 until numbers.size) {
            if (visited[idx] == true) continue
            visited[idx] = true
            combi[curIdx] = numbers[idx]
            findCombi(targetLength, curIdx + 1)
            visited[idx] = false
        }
    }

    private fun isPrime(num: Int): Boolean {
        return when (num) {
            0 -> false
            1 -> false
            2 -> true
            3 -> true
            5 -> true
            7 -> true
            else -> {
                for (div in 2..num / 2) {
                    if (num % div == 0) return false
                }
                true
            }
        }
    }


    private fun initial(num: String) {
        LENGTH = num.length
        combi = CharArray(LENGTH) { ' ' }
        numbers = num.toCharArray()
        visited = BooleanArray(numbers.size) { false }
    }
}