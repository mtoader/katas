package ro.redeul.katas.algos

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}

class SplitOddEvenTest extends FeatureSpec with GivenWhenThen with Matchers {
  scenario("split an array") {
    Given("[4, 6, 3, 7, 2, 9, 8]")
    val data = Array(4, 6, 3, 7, 2, 9, 8)

    Then("it should split to [4, 6, 8, 2, 7, 9, 3]")
    SplitOddEven(data) should be (Array(4, 6, 8, 2, 7, 9, 3))
  }
}
