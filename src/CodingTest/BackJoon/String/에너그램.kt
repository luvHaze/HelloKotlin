package CodingTest.BackJoon.String


fun main(){
    val sin = System.`in`.bufferedReader()
    var str1 = sin.readLine().toCharArray()
    var str2 = sin.readLine().toCharArray()

    var cnt = 0

    for(i in str1.indices){
        for(j in str2.indices) {

            if(str1[i] == str2[j]) {
                str2[j] = '-'
                cnt++
                break
            }

        }
    }

    println((str1.size - cnt) + (str2.size - cnt))
}