package ComputerScience.Algorithms

fun main() {
    val array = intArrayOf(6, 2, 1, 3, 4, 5)

    val arraySize = array.size
    for (std in 0 until arraySize) {
        var stdIndex = std
        for (idx in std + 1 until arraySize) {
            if (array[idx] < array[stdIndex]) stdIndex = idx
        }
        swap(array, std, stdIndex)
    }
    array.forEach {
        print("$it ")
    }
}

private fun swap(array: IntArray, from: Int, to: Int) {
    val temp = array[from]
    array[from] = array[to]
    array[to] = temp
}