import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val conferenceNum = sc.nextInt()
    var conferenceTime = arrayListOf<Pair<Int,Int>>()
    var answer = 0

    for (i in 1..conferenceNum) {
        conferenceTime.add(Pair(sc.nextInt(),sc.nextInt()))
    }

    var sorted = conferenceTime.sortedBy { it.second }
    sorted.forEach {
        var count = 1
        var nextStep = it.second

        for(i in sorted.indices){
            if(nextStep<=sorted[i].first){
                count++
                nextStep=sorted[i].second
            }
        }
        if(answer<=count) answer=count
    }

    print(answer)
}