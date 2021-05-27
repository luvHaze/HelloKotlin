package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val meetings = init()
    val rooms = IntArray(meetings.size + 1) { 0 }
    rooms[1] = meetings[0].end

    for (idx in 1 until meetings.size) {
        val meetingStart = meetings[idx].start
        for(roomIdx in 1 until rooms.size) {
            val endTime = rooms[roomIdx]
            if (endTime <= meetingStart) {
                rooms[roomIdx] = meetings[idx].end
                break
            }
        }
    }

    val answer = rooms.count { it != 0 }
    print(answer)
}

private fun init(): ArrayList<Meeting> {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val meetingNumber = br.readLine().toInt()
    val meetings = arrayListOf<Meeting>()

    repeat(meetingNumber) {
        val tk = StringTokenizer(br.readLine())
        val start = tk.nextToken().toInt()
        val end = tk.nextToken().toInt()

        meetings.add(Meeting(start, end))
    }

    meetings.sortBy { it.start }
    return meetings
}

private data class Meeting(
    val start: Int,
    val end: Int
)