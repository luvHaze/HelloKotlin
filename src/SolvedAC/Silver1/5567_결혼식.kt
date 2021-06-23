package SolvedAC.Silver1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private lateinit var friendsMap: Array<BooleanArray>
private lateinit var visited: IntArray
private var N = 0

fun main() {
    init()
    bfs()

    val invitedFriend = visited.count { it in 2..3 }
    print(invitedFriend)
}

private fun bfs() {
    val queue: Queue<Int> = LinkedList<Int>()
    queue.offer(1)
    visited[1] = 1

    while(queue.isNotEmpty()) {
        val currentFriend = queue.poll()

        for(friend in 1..N) {
            if(friendsMap[currentFriend][friend] == true && visited[friend] == -1) {
                visited[friend] = visited[currentFriend] + 1
                queue.offer(friend)
            }
        }
    }
}


private fun init() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    N = br.readLine().toInt()
    val M = br.readLine().toInt()

    friendsMap = Array(N + 1) { BooleanArray(N + 1) { false } }
    visited = IntArray(N + 1) { -1 }
    repeat(M) {
        val tk = StringTokenizer(br.readLine())
        val from  = tk.nextToken().toInt()
        val to = tk.nextToken().toInt()

        friendsMap[from][to] = true
        friendsMap[to][from] = true
    }
}