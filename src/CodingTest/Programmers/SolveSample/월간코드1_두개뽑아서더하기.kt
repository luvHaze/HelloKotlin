package CodingTest.Programmers.SolveSample

import java.util.TreeSet

private class TwoSelectPlusSolution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf(0)
        var size = numbers.size
        var results = TreeSet<Int>()

        for(i in 0..size-1) {
            for(j in i+1..size-1) {
                results.add(numbers[i] + numbers[j])
            }
        }

        return results.toIntArray()
    }
}