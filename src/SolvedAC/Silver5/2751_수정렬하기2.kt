package SolvedAC.Silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val numbers = arrayListOf<Int>()
    repeat(N) {
        numbers.add(br.readLine().toInt())
    }

    val answer = StringBuilder()
    val sortedNumbers = mergeSort(numbers)
    sortedNumbers.forEach {
        answer.append("$it\n")
    }

    print(answer)
}

private fun mergeSort(numbers: List<Int>): List<Int> {
    if(numbers.size == 1) {
        return numbers
    }
    val arr = intArrayOf(1,2,3,4)
    val middleIdx = numbers.size / 2
    val leftNumbers = numbers.subList(0, middleIdx)
    val rightNumbers = numbers.subList(middleIdx, numbers.size)

    return merge(mergeSort(leftNumbers), mergeSort(rightNumbers))
}

private fun merge(leftList: List<Int>, rightList: List<Int>): List<Int> {
    val mergedList = mutableListOf<Int>()
    var rightIdx = 0
    var leftIdx = 0

    while(leftIdx < leftList.size && rightIdx < rightList.size) {
        if(leftList[leftIdx] <= rightList[rightIdx]) {
            mergedList.add(leftList[leftIdx])
            leftIdx++
        } else {
            mergedList.add(rightList[rightIdx])
            rightIdx++
        }
    }

    while(leftIdx < leftList.size) {
        mergedList.add(leftList[leftIdx])
        leftIdx++
    }

    while(rightIdx < rightList.size) {
        mergedList.add(rightList[rightIdx])
        rightIdx++
    }

    return mergedList
}