package Algopa.Task2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var seatCount = br.readLine().toInt()
    var seatInfo = br.readLine().toString()

    var cnt = 1
    var LCount = 0

    for(i in seatInfo.indices) {
        if(seatInfo[i] == 'S') {
            cnt++
        } else {
            LCount++
            if(LCount == 2){
                cnt++
                LCount = 0
            }
        }
    }

    if(LCount == 1) cnt++
    print(min(cnt, seatCount))

}