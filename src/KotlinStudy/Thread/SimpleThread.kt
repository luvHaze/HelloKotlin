package KotlinStudy.Thread

//클래스
class SimpleThread : Thread() {
    override fun run() {
        println("Class Thread ${Thread.currentThread()}")
    }
}

// 인터페이스
class SimpleRunnable : Runnable {
    override fun run() {
        println("Interface Thread ${Thread.currentThread()}")
    }
}

fun main() {
    // 클래스 쓰레드 생성&실행
    val threadClass = SimpleThread()
    threadClass.start()

    // 인터페이스 쓰레드 생성&실행
    val runnable = SimpleRunnable()
    val thread2 = Thread(runnable)

    thread2.start()

    // 익명객체 쓰레드 생성&실
    object : Thread() {
        override fun run() {
            println("object Thread: ${Thread.currentThread()}")
        }
    }.start()

    // 람다식 쓰레드 생성&실행
    Thread {
        println("Lambda Thread: ${Thread.currentThread()}")
    }.start()

    thread(start = true) {
        println("Current Threads(Custom function) : ${Thread.currentThread()}")
        println("Priority: ${Thread.currentThread().priority}")
        println("Name : ${Thread.currentThread().name}")
        println("Name : ${Thread.currentThread().isDaemon}")
    }

}

public fun thread(start: Boolean = true,
                  isDaemon: Boolean = false,
                  contextLoader: ClassLoader? = null,
                  name: String? = null,
                  priority: Int = -1, block: () -> Unit): Thread {
    val thread = object :Thread() {
        override fun run() {
            block()
        }
    }
    if(isDaemon)
        thread.isDaemon = true
    if(priority > 0) //우선순위 (1:낮음, ~5: 보통, ~10: 높음)
        thread.priority = priority
    if(name != null)
        thread.name=name
    if(contextLoader != null)
        thread.contextClassLoader = contextLoader
    if(start)
        thread.start()

    return thread
}