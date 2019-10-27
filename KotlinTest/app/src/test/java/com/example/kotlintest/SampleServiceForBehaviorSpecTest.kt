package com.example.kotlintest

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.BehaviorSpec

class SampleServiceForBehaviorSpecTest: BehaviorSpec() {
    init {
        val service = SampleService()
        given("executeで") {
            `when`("paramが１の場合") {
                val result = service.execute(1)
                then("oneが返る") {
                    result shouldBe "one"
                }
            }
        }
    }

}