package Programmers.Level1

//


class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var strTemp = n.toString()
        var tempArray = arrayListOf<Char>()

        strTemp.forEach {
            tempArray.add(it)
        }
        tempArray.sortDescending()

        answer = tempArray.joinToString("").toLong()
        return answer
    }
}
    /*

     최강의 숏코딩
    class Solution {
        fun solution(n: Long): Long = String(n.toString().toCharArray().sortedArrayDescending()).toLong()
    }

    */
