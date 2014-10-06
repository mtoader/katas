package ro.redeul.katas.algos

import org.scalatest.{GivenWhenThen, Matchers, FeatureSpec}

class IslandProfileTest extends FeatureSpec with GivenWhenThen with Matchers {
  scenario("Complicated") {
    Given("simple tree")
    val profile = Seq((0, 0), (1, 7), (2, 5), (3, 10), (4, 2), (5, 3), (6, 1), (7, 6), (8, 4), (9, 11), (10, 0))

    Then("the value should be")
    IslandProfile.waterVolume(profile) should be (34.971428f +- 0.000001f)
  }

  scenario("Original problem") {
    Given("a profile")
    val island = Seq((0, 0), (1, 10), (3, 1), (5, 5), (6, 20), (7, 0))

    Then("the volume should be 25.5")
    IslandProfile.waterVolume(island) should be (23.833332f +- 0.000001f)
  }

  scenario("Hill type island") {
    Given("a hill like island")
    val island = Seq((0, 0), (2, 10), (5, 0))

    Then("the water volume should be 0")
    IslandProfile.waterVolume(island) should be(0.0f)
  }

  scenario("One puddle island") {
    Given("a one puddle island")
    val island = Seq((0, 0), (1, 5), (2, 10), (3, 5), (4, 10), (5, 0))

    Then("the water volume should be 0")
    IslandProfile.waterVolume(island) should be(5.0f)
  }

  scenario("One puddle island with higher peak to the left") {
    Given("a one puddle island")
    val island = Seq((0, 0), (1, 5), (3, 15), (5, 5), (6, 10), (7, 0))

    Then("the water volume should be 0")
    IslandProfile.waterVolume(island) should be(5.0f)
  }


  scenario("One puddle island with higher peak to the right") {
    Given("a one puddle island")
    val island = Seq((0, 0), (1, 5), (2, 10), (3, 5), (5, 15), (7, 0))

    Then("the water volume should be 0")
    IslandProfile.waterVolume(island) should be(5.0f)
  }

  scenario("Two puddle island") {
    Given("a two puddles island")
    val island = Seq((0, 0), (1, 5), (2, 10), (3, 5), (4, 10), (5, 8), (6, 9), (7, 0))

    Then("the water volume should be 0")
    IslandProfile.waterVolume(island) should be(5.75f)
  }

}
