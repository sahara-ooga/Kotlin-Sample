/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package coroutine

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong

fun main(args: Array<String>) {
//    secondExample()
    thirdExample()
}

fun firstExample() {
    println("Start")

    // Start a coroutine
    GlobalScope.launch {
        delay(1000)//delay() function that's like Thread.sleep(), but better: it doesn't block a thread, but only suspends the coroutine itself.
        println("Hello")
    }

    runBlocking {
        delay(2000)
    }
//    Thread.sleep(2000) // wait for 2 seconds
    // if you comment out sleep, println("Hello") will not execute.
    // because the coroutine and delay function are non-blocking.
    println("Stop")

    /*実行結果：
    * start
      coroutine!
      end
    *
    * */
}

fun secondExample() {
//    val c = AtomicLong()
//
//    for (i in 1..1_000_000L)
//        GlobalScope.launch {
//            c.addAndGet(i)
//        }
//
//    println(c.get())

    val deferred : List<Deferred<Int>> = (1..1_000_000).map { n ->
        GlobalScope.async {
            delay(1000)//does not run over 1,000,000 seconds because this run in parallel.
            n * 2
        }
    }

    runBlocking {
        val sum = deferred.sumBy { it.await() }
        //See the results in coroutine
        println("Sum: $sum")
    }
}

fun thirdExample() {
    suspend fun workload(n: Int): Int {
        delay(1000)
        return n
    }

    val deferred : List<Deferred<Int>> = (1..1_000_000).map { n ->
        GlobalScope.async {
            workload(n)
        }
    }
    runBlocking {
        val sum = deferred.sumBy { it.await() }
        //See the results in coroutine
        println("Sum: $sum")
    }
}