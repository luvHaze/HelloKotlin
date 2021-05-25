package CodingTest.Programmers.SolveSample

private class SnailSolution {

    private val map: Array<IntArray> by lazy { Array(N) { IntArray(N) { 0 } } }
    private var N = 0
    private var count = 1

    fun solution(n: Int): IntArray {
        N = n

        var row = -1
        var col = 0
        while(N > 0) {
            for (idx in 0 until N) {
                map[++row][col] = count++
            }
            for (idx in 0 until N - 1) {
                map[row][++col] = count++
            }
            for (idx in 0 until N - 2) {
                map[--row][--col] = count++
            }
            N -= 3
        }

        var answer = ArrayList<Int>()

        map.forEach{ arr->
            arr.forEach{
                if(it != 0) {
                    answer.add(it)
                }
            }
        }
        return answer.toIntArray()
    }
}