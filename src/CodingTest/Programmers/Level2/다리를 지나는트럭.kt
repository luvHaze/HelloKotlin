package CodingTest.Programmers.Level2

import java.util.*
import kotlin.collections.HashMap
import kotlin.time.seconds

private class BridgeTruckSolution {
    fun solution(bridge_length: Int, max_weight: Int, truck_weights: IntArray): Int {
        val truckNumber = truck_weights.size
        val trucks = truck_weights.map { Truck(it, 0) }
        val bridge: Queue<Truck> = LinkedList<Truck>()
        var turn = 0
        var curWeight = 0
        var passedTruck = 0
        var time = 1

        while(passedTruck < truckNumber) {
            if(turn < truckNumber && curWeight + trucks[turn].weight <= max_weight) {
                curWeight += trucks[turn].weight
                bridge.offer(trucks[turn])
                turn ++
            }

            for(truck in bridge) {
                truck.curPosition++
            }

            if(bridge.isNotEmpty() && bridge.peek().curPosition >= bridge_length) {
                curWeight -= bridge.poll().weight
                passedTruck ++
            }

            time++
        }

        return time
    }

    inner class Truck (
        var weight: Int,
        var curPosition: Int
    )
}