package com.karumi.maxibonkata

import io.kotlintest.properties.forAll
import io.kotlintest.specs.ShouldSpec

class DeveloperTest : ShouldSpec() {
    init {
        "Developer"{
            should("a developer can consume zero or a positive number of maxibons") {
                forAll { name: String, numberOfMaxibons: Int ->
                    val dev = Developer(name, numberOfMaxibons)
                    println(dev)
                    dev.maxibonsToGrab >= 0
                }
            }
        }
    }
}