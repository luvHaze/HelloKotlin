package Programmers.Level2

import java.util.*

class Solution {

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = arrayListOf<Int>()
        var restDayArr = arrayListOf<Int>()

        // progresses배열의 값을 남을 일 수로 변경
        for(i in progresses.indices){
            var restWork = 100 - progresses[i]
            if(restWork % speeds[i] == 0) progresses[i] = restWork / speeds[i]
            else progresses[i] = restWork / speeds[i] +1
        }

        // 큐를 만들어서 progresses 값들을 넣어줌 (삭제,삽입에 용이)
        var postQueue: Queue<Int> = LinkedList<Int>()
        progresses.forEach{
            postQueue.add(it)
        }

        // 큐가 빌때까지 반복하며 answer에 기준값보다 작은값들을 묶어서 보내줌
        var stdNum = postQueue.poll()
        var count = 1
        while(!postQueue.isEmpty()){
            var frontValue = postQueue.poll()

            if(stdNum >= frontValue){
                count++
            }else{
                answer.add(count)
                count = 1
                stdNum = frontValue
            }
        }
        answer.add(count)

        return answer.toIntArray()
    }


}