package com.example.kotlintest

import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class ForAllTest : StringSpec({
    val service = SampleService()

    "forAll" {
        // NOTE: type inference does not work.
//        forAll(
//            row(1, "one"),
//            row(2, "two"),
//            row(3, "default")
//        ) { param: Int, resut: String ->
//            service.execute(param) shouldBe resut
//        }

        val data = table(
            headers("param", "result"),
            row(1, "one"),
            row(2, "two"),
            row(3, "default")
        )
        forAll(data) { param, result ->
            service.execute(param) shouldBe result
        }
    }
})