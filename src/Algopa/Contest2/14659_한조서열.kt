package Algopa.Contest2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var number = br.readLine().toInt()

    var arrHanzo = ArrayList<Int>()
    var token = StringTokenizer(br.readLine())
    for(i in 1..number) {
        arrHanzo.add(token.nextToken().toInt())
    }

    var result = 0
    for(i in 0 until number) {

        var hanzo = arrHanzo[i]
        var cnt = 0

        for(j in i+1 until number) {
            if(arrHanzo[j] > hanzo)
                break
            else
                cnt++
        }

        result = max(result, cnt)
    }

    print(result)
}