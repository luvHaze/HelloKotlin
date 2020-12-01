package Algopa.Task1.별찍기22

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arrMap: Array<CharArray>
fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var number = br.readLine().toInt()


    if(number == 1) {
        print("*")
    } else {
        var width = 4 * number - 3
        var height = width + 2
        arrMap = Array<CharArray>(height) {CharArray(width)}

        initArray(arrMap, width,height)
        drawStars(number, 0, 4*number - 4)
        printArray(arrMap, width, height)
    }

}

fun drawStars(number: Int, x: Int, y: Int) {

    var mX = x
    var mY = y

    var width = 4 * number - 3
    var height = width + 2

    for (i in 1 until width) arrMap[mX][mY--] = '*'
    for (i in 1 until height) arrMap[mX++][mY] = '*'
    for (i in 1 until width) arrMap[mX][mY++] = '*'
    for (i in 1 until height - 2) arrMap[mX--][mY] = '*'

    arrMap[mX][mY] = '*'
    mY--
    arrMap[mX][mY] = '*'

    if(number == 2) {
        arrMap[mX][mY-1] = '*'
        arrMap[mX+1][mY-1] = '*'
        arrMap[mX+2][mY-1] = '*'
        return
    }

    drawStars(number-1, mX, mY-1)
}


fun initArray(arr: Array<CharArray>, width: Int, height: Int) {
    for(x in 0 until height) {
        for(y in 0 until width) {
            arr[x][y] = ' '
        }
    }
}

fun printArray(arr: Array<CharArray>, width: Int, height: Int) {
    for(x in 0 until height) {

        if(x == 1) {
            print("*\n")
            continue
        }

        for(y in 0 until width) {
            print(arr[x][y])
        }
        print("\n")
    }
}