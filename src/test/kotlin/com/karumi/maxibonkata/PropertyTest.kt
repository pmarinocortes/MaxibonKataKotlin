package com.karumi.maxibonkata

import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec


class PropertyTest : ShouldSpec() {
    //tests
    init {
        should("return the length of the string").config(invocations = 10, threads = 2) {
            "sammy".length shouldBe 5
            "".length shouldBe 0
        }

        "Strings" {
            should ("two consecutive strings have the same size") {
                forAll { value: String, value2: String ->
                    (value + value2).count() == (value2 + value).count()
                }
            }
        }

        "String" {
            should("reverse twice gets the same value") {
                forAll{value: String ->
                    (value == value.reversed().reversed())
                }
            }
        }
    }
}
