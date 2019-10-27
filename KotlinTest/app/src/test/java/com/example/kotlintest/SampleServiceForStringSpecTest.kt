package com.example.kotlintest

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class SampleServiceForStringSpecTest: StringSpec() {
    init {
        val service = SampleService()
        "executeでparamが１の場合oneが返る" {
            service.execute(1) shouldBe "one"
        }
    }
}

class SampleService {
    fun execute(num: Int): String {
        return "one"
    }
}
