import java.util.*

/* - 백준 11399번 문제 (탐욕기법)
 * - ATM
 */

fun main(){
    val input = Scanner(System.`in`)
    val nPeople = input.nextInt()
    val pTime = arrayListOf<Int>()
    var answer = 0

    for(i in 0 until nPeople){ pTime.add(input.nextInt()) }
    pTime.sort()

    for(people in 0..nPeople-1){
        for (time in 0..people){
            answer+=pTime[time]
        }
    }
    print(answer)
}