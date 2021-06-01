package SolvedAC.Silver2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)
private const val UP = 0
private const val DOWN = 1
private const val LEFT = 2
private const val RIGHT = 3
private var currentDirection = UP
private var currentPosition = Turtle(0, 0)

private var map = Array(500) { IntArray(500) { 0 } }
fun main() {
    val commands = init()
    for (command in commands) {
        currentPosition = Turtle(0, 0)
        var left = 0
        var right = 0
        var down = 0
        var up = 0
        command.forEach {
            move(it)

            if (currentPosition.x < 0) {
                if (abs(currentPosition.x) > left) {
                    left = abs(currentPosition.x)
                }
            } else if (currentPosition.x > 0) {
                if(currentPosition.x > right) {
                    right = currentPosition.x
                }
            }

            if (currentPosition.y < 0) {
                if (abs(currentPosition.y) > down) {
                    down = abs(currentPosition.y)
                }
            } else if (currentPosition.y > 0) {
                if(currentPosition.y > up) {
                    up = currentPosition.y
                }
            }
        }
        println((left + right) * (up + down))
    }
}

private fun init(): ArrayList<String> {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val caseNumber = br.readLine().toInt()

    val commands = arrayListOf<String>()
    repeat(caseNumber) {
        commands.add(br.readLine())
    }

    return commands
}

private fun move(command: Char) {
    when (command) {
        'F' -> {
            currentPosition.x += dx[currentDirection]
            currentPosition.y += dy[currentDirection]
        }
        'B' -> {
            currentPosition.x += (dx[currentDirection] * -1)
            currentPosition.y += (dy[currentDirection] * -1)
        }
        'L' -> {
            changeDirection('L')
        }
        'R' -> {
            changeDirection('R')
        }
    }
}

private fun changeDirection(turn: Char) {
    when (currentDirection) {
        UP -> {
            when (turn) {
                'L' -> currentDirection = LEFT
                'R' -> currentDirection = RIGHT
            }
        }
        DOWN -> {
            when (turn) {
                'L' -> currentDirection = RIGHT
                'R' -> currentDirection = LEFT
            }
        }
        RIGHT -> {
            when (turn) {
                'L' -> currentDirection = UP
                'R' -> currentDirection = DOWN
            }
        }
        LEFT -> {
            when (turn) {
                'L' -> currentDirection = DOWN
                'R' -> currentDirection = UP
            }
        }
    }
}

private class Turtle(
    var x: Int,
    var y: Int
)