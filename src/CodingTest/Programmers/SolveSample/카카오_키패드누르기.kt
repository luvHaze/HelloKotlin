package CodingTest.Programmers.SolveSample

import kotlin.math.abs

private class KeyPadSolution {
    private val keyPad = HashMap<Int, Position>()
    private var leftHand = Position(4, 1)
    private var rightHand = Position(4, 3)

    fun solution(numbers: IntArray, hand: String): String {
        val mainHand = if (hand == "right") 'R' else 'L'
        var records = ""

        initKeyPad()
        for (number in numbers) {
            val arrive = keyPad[number]!!
            when {
                isLeftSide(number) -> {
                    leftHand = arrive
                    records += 'L'
                }
                isRightSide(number) -> {
                    rightHand = arrive
                    records += 'R'
                }
                else -> {
                    records += getBestWay(arrive, mainHand)
                }
            }
        }

        println(records)

        return records
    }

    private fun getBestWay(arrive: Position, mainHand: Char): Char {
        val leftDistance = getDistance(leftHand, arrive)
        val rightDistance = getDistance(rightHand, arrive)

        when {
            leftDistance < rightDistance -> {
                leftHand = arrive
                return 'L'
            }
            leftDistance > rightDistance -> {
                rightHand = arrive
                return 'R'
            }
            leftDistance == rightDistance -> {
                if (mainHand == 'R') {
                    rightHand = arrive
                } else {
                    leftHand = arrive
                }
                return mainHand
            }
        }

        return ' '
    }

    private fun getDistance(from: Position, to: Position): Int {
        val row = abs(from.row - to.row)
        val col = abs(from.col - to.col)

        return row + col
    }

    private fun initKeyPad() {
        keyPad[1] = Position(1, 1)
        keyPad[2] = Position(1, 2)
        keyPad[3] = Position(1, 3)
        keyPad[4] = Position(2, 1)
        keyPad[5] = Position(2, 2)
        keyPad[6] = Position(2, 3)
        keyPad[7] = Position(3, 1)
        keyPad[8] = Position(3, 2)
        keyPad[9] = Position(3, 3)
        keyPad[0] = Position(4, 2)
    }

    private fun isRightSide(number: Int): Boolean {
        return number == 3 || number == 6 || number == 9
    }

    private fun isLeftSide(number: Int): Boolean {
        return number == 1 || number == 4 || number == 7
    }

    inner class Position(
        val row: Int,
        val col: Int
    )
}