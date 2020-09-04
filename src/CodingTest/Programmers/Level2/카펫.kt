package CodingTest.Programmers.Level2


fun solution(brown: Int, yellow: Int): IntArray {
    var answer = IntArray(2)
    var allSize = brown + yellow

    for (width in 1..allSize) {
        var height = allSize / width
        if (allSize % width == 0 && width >= height && (width - 2) * (height - 2) == yellow) {
            answer[0] = width
            answer[1] = height
        }
    }

    return answer
}
