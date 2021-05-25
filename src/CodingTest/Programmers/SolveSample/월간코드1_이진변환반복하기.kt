package CodingTest.Programmers.SolveSample

private class BinaryChangeSolution {

    private var removedNumbers = 0
    private var count = 0

    fun solution(s: String): IntArray {
        var answer: IntArray = IntArray(2) { 0 }

        recursive(s)

        answer[0] = count
        answer[1] = removedNumbers

        return answer
    }

    fun recursive(string: String) {
        if(string.length == 1) return

        count++

        val removedLength = string.count { it == '0'}
        val remainLength = string.length - removedLength
        removedNumbers += removedLength

        recursive(makeBinary(remainLength))
    }

    fun makeBinary(number: Int): String {
        var string = StringBuilder()
        var num = number

        while(true) {
            if(num == 1 || num == 0)  {
                string.append(num)
                break
            }
            if(num % 2 == 0) {
                string.append(0)
            } else {
                string.append(1)
            }
            num /= 2

        }

        return string.toString().reversed()
    }
}