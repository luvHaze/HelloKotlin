package CodingTest.Programmers.Level2

class H_IndexSolution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var size = citations.size

        citations.sort()
        var middleValue = citations[size / 2]
        var max = citations.max()!!

        for(idx in 1..max) {
            val under = citations.count { it <= idx }
            val over = citations.count { it >= idx }

            if(under <= idx && over >= idx) answer = idx
        }

        print(answer)

        return answer
    }

}