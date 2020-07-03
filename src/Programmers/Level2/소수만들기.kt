
// 다른사람 풀이 : 모든경우의 수를 구하면서 그 중 소수가 나타나면 answer를 ++ 해줬다

fun solution(nums: IntArray): Int {
    nums.sort() //1. 정렬해준다.

    var answer = 0
    val numsSize = nums.size
    val minPrime = nums[0] + nums[1] + nums[2] // 앞에 3개를 더해서 최소로 나올수 있는 숫자를 구한다
    val maxPrime = nums[numsSize - 1] + nums[numsSize - 2] + nums[numsSize - 3] // 마찬가지로 뒤에 3개를 더해서 최대로 나올수 있는 숫자 구한다.
    var primeList = arrayListOf<Int>()  // 범위 내 나올수 있는 소수를 담을 Arr

    // minPrime~ㅡmaxPrime 범위에서 소수들을 primeList에 담아준다.
    for (i in minPrime..maxPrime) {
        if (isPrime(i)) primeList.add(i)
    }

    // 배열 값 3개로 만들 수 있는 모든 경우의수들 중에서
    // primeList에 담겨있는 친구들이 있다면 answer++
    for (i in 0..numsSize - 3) {
        for (j in i + 1..numsSize - 2) {
            for (k in j + 1..numsSize - 1) {
                if (primeList.contains(nums[i] + nums[j] + nums[k])) answer++
            }
        }
    }

    return answer
}

// 소수를 판별해준다.
fun isPrime(num: Int): Boolean {
    var ali = 0
    for (i in 1..num) {
        if (num % i == 0) ali++
    }
    if (ali == 2) return true

    return false
}

