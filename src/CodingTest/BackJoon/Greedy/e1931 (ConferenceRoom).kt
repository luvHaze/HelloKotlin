import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val conferenceNum = br.readLine().toInt()
    val conferences = mutableListOf<Conference>()

    repeat(conferenceNum) {
        val token = StringTokenizer(br.readLine())
        val start = token.nextToken().toInt()
        val end = token.nextToken().toInt()
        conferences.add(Conference(start, end))
    }

    conferences.sortWith(compareBy(Conference::start))
    conferences.sortWith(compareBy(Conference::end))

    var endTime = 0
    var answer = 0
    conferences.forEach {
        if (it.start >= endTime) {
            answer++
            endTime = it.end
        }
    }

    print(answer)
}

data class Conference(val start: Int, val end: Int)

