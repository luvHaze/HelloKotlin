package SolvedAC.Gold5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var pushes: IntArray
private var MAX_FLOOR = 0
private var START = 0
private var TARGET = 0
private var UP_UNIT = 0
private var DOWN_UNIT = 0

private const val UP = 0
private const val DOWN = 1
private var min = Int.MAX_VALUE

fun main() {
    init()

    if(START == TARGET) {
        print(0)
    } else {
        bfs(START)
        if (min == Int.MAX_VALUE) {
            print("use the stairs")
        } else {
            print(min)
        }
    }
}

private fun bfs(floor: Int) {
    val queue: ArrayList<Int> = ArrayList<Int>()
    queue.add(floor)
    pushes[floor] = 1

    while (queue.isNotEmpty()) {
        val currentFloor = queue.removeAt(0)
        if (pushes[currentFloor] > min) return
        for (dir in 0..1) {
            var nextFloor = 0
            when (dir) {
                UP -> nextFloor = currentFloor + UP_UNIT
                DOWN -> nextFloor = currentFloor - DOWN_UNIT
            }
            if (nextFloor < 1 || nextFloor > MAX_FLOOR) continue

            if (nextFloor == TARGET) {
                min = pushes[currentFloor]
                return
            }

            if (pushes[nextFloor] == 0) {
                queue.add(nextFloor)
                pushes[nextFloor] = pushes[currentFloor] + 1
            }
        }
    }
}

private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tk = StringTokenizer(br.readLine())

    MAX_FLOOR = tk.nextToken().toInt()
    START = tk.nextToken().toInt()
    TARGET = tk.nextToken().toInt()
    UP_UNIT = tk.nextToken().toInt()
    DOWN_UNIT = tk.nextToken().toInt()

    pushes = IntArray(MAX_FLOOR+1) { 0 }
}

