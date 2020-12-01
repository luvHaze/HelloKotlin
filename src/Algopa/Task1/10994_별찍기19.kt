package Algopa.Task1

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var map: Array<CharArray>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val number = br.readLine().toInt()
    var length = 4 * (number - 1) + 1

    map = Array<CharArray>(length) {CharArray(length)}

    initArray(map, length)
    drawStar(number, 0, 0)
    printArray(map, length)

}

private fun drawStar(number: Int, x: Int, y: Int) {

    if (number == 1) {
        map[x][y] = '*'
        return
    }

    var length = 4 * (number - 1) + 1

    //Width
    for(j in y until y+length) {
        map[x][j] = '*'
        map[x+length-1][j] ='*'
    }

    //Height
    for(i in x until x+length) {
        map[i][y] = '*'
        map[i][y+length-1] ='*'
    }

    drawStar(number-1, x+2, y+2)
    return
}

fun initArray(arr: Array<CharArray>, length: Int) {
    for(x in 0 until length) {
        for(y in 0 until length) {
            arr[x][y] = ' '
        }
    }
}

fun printArray(arr: Array<CharArray>, length: Int) {
    for(x in 0 until length) {
        for(y in 0 until length) {
            print(arr[x][y])
        }
        print("\n")
    }
}