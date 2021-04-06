package ComputerScience.Algorithms

fun main() {
    val array = intArrayOf(6, 2, 1, 3, 4, 5)

    val arraySize = array.size
    for(i in array.indices) {
        for(j in 0 until arraySize -i -1) {
            if(array[j] > array[j+1]) swap(array, j, j+1)
        }
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