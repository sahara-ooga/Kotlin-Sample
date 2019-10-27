package com.example.coroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        useCoroutines()
    }
}

fun MainActivity.useCoroutines() {
    runBlocking {//block thread until coroutine finishes. Wait until launch { } ends.
        launch {// async execution
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }
}