package SolvedAC.Bronze1

import java.io.BufferedReader
import java.io.InputStreamReader

private const val L = 0
private const val O = 1
private const val V = 2
private const val E = 3
private var max = 0
private var herName = ""

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val myName =br.readLine()
    val girlNumber =br.readLine().toInt()

    val myNameArr = countAlphabet(myName)

    val girls = arrayListOf<String>()
    repeat(girlNumber) {
        val girlName = br.readLine()
        girls.add(girlName)
    }
    girls.sortDescending()

    girls.forEach { girlName ->
        val girlNameArr = countAlphabet(girlName)
        val lovePoint = calcLove(myNameArr, girlNameArr)
        if(max <= lovePoint) {
            max = lovePoint
            herName = girlName
        }
    }

    print(herName)
}

private fun calcLove(myArr: IntArray, girlArr: IntArray): Int {
    val sumArr = IntArray(4) { 0 }
    sumArr[L] = myArr[L] + girlArr[L]
    sumArr[O] = myArr[O] + girlArr[O]
    sumArr[V] = myArr[V] + girlArr[V]
    sumArr[E] = myArr[E] + girlArr[E]

    return ((sumArr[L] + sumArr[O]) * (sumArr[L] + sumArr[V]) * (sumArr[L] + sumArr[E]) *
            (sumArr[O] + sumArr[V]) * (sumArr[O] + sumArr[E]) * (sumArr[V] + sumArr[E])) % 100
}

private fun countAlphabet(name: String): IntArray {
    val arr = IntArray(4) { 0 }
    arr[L] = name.count { it == 'L' }
    arr[O] = name.count { it == 'O' }
    arr[V] = name.count { it == 'V' }
    arr[E] = name.count { it == 'E' }
    return arr
}