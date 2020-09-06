package KotlinStudy.Thread

import kotlinx.coroutines.*


fun main() {
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            println("World")
            doSomething()
        }
        println("Hello")
        println("job : ${job.isActive}, ${job.isCompleted}")
//    Thread.sleep(2000L)
        job.join() // job 이라는 코루틴을 끝날때까 기다려준다.지
        println("job : ${job.isActive}, ${job.isCompleted}")
    }
}

suspend fun doSomething() {
    println("Do Something")
}