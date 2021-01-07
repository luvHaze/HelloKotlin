package Baekjoon.Grage10_Recursive

import java.io.*

private lateinit var bw: BufferedWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val number = br.readLine().toInt()

    for (i in 0 until number) {
        for (j in 0 until number) {
            star(i, j, number)
        }
        bw.newLine()
    }

    bw.flush()
    bw.close()
}

fun star(i: Int, j: Int, num: Int) {

    if ((i / num) % 3 == 1 && (j / num) % 3 == 1) {
        bw.write(" ")
    } else {
        if (num / 3 == 0)
            bw.write("*")
        else
            star(i, j, num / 3)
    }
}
