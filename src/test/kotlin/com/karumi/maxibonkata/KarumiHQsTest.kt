package com.karumi.maxibonkata

import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.ShouldSpec

class KarumiHQsTest : ShouldSpec() {

    init {

        should("the number of maxibons is always more than 2") {
            forAll(Generators.AnyDeveloperGenerator()) { anyDeveloper: Developer ->
                val karumiHQs = KarumiHQs()
                karumiHQs.openFridge(anyDeveloper)
                karumiHQs.maxibonsLeft > 2
            }
        }

        should("the number of maxibons is always more than 2 with a group of developers") {
            forAll(Gen.list(Generators.AnyDeveloperGenerator()).filter { it.isNotEmpty() }) { developers ->
                val karumiHQs = KarumiHQs()
                karumiHQs.openFridge(developers)
                karumiHQs.maxibonsLeft > 2

            }
        }

    }
}