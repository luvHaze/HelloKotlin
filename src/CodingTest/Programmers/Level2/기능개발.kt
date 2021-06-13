package CodingTest.Programmers.Level2

import java.util.*

class DevelopMethodSolution {

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = arrayListOf<Int>()
        val workQueue = makeWorkQueue(progresses, speeds)

        val firstWork = workQueue.peek()
        var day = getCompleteDay(firstWork)
        var pollCount = 0
        while (workQueue.isNotEmpty()) {
            val frontWork = workQueue.peek()
            if (frontWork.progress + frontWork.speed * day >= 100) {
                workQueue.poll()
                pollCount++
            } else {
                day = getCompleteDay(frontWork)
                answer.add(pollCount)
                pollCount = 0
            }

            if (workQueue.isEmpty()) answer.add(pollCount)
        }

        return answer.toIntArray()
    }

    fun getCompleteDay(work: Work): Int {
        var day = 0
        var extraProgress = 100 - work.progress

        while (extraProgress > 0) {
            day++
            extraProgress -= work.speed
        }
        return day
    }

    fun makeWorkQueue(progresses: IntArray, speeds: IntArray): Queue<Work> {
        val queue: Queue<Work> = LinkedList<Work>()
        for (idx in 0 until progresses.size) {
            queue.add(Work(progresses[idx], speeds[idx]))
        }
        return queue
    }

    inner class Work(
        var progress: Int,
        val speed: Int
    )
}