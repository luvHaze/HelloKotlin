package CodingTest.Programmers.SolveSample

private class TripletSolution {
    fun solution(n: Int): Int {
        var answer: Int = 0

        getTriplet(n).forEachIndexed{ idx, char ->
            val number = char.toString().toInt()
            answer = answer + (number * sqrtThree(idx))
        }

        return answer
    }
}

fun sqrtThree(times: Int): Int {
    var result = 1
    repeat(times) {
        result *= 3
    }
    return result
}

fun getTriplet(number: Int): String {
    var num = number
    var result = StringBuilder()
    while(true) {
        if(num < 3)  {
            result.append(num % 3)
            break
        }
        result.append(num % 3)
        num /= 3
    }
    return result.toString().reversed()
}