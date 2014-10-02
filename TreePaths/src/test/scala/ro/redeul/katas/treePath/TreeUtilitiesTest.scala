package ro.redeul.katas.treePath

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import ro.redeul.katas.treePaths.{TreeUtilities, Tree}

class TreeUtilitiesTest extends FeatureSpec with GivenWhenThen with Matchers {

  scenario("Testing counting of root paths") {
    Given("a one node tree")
    val root = new Tree(1)

    Then("it should find a path of sum 1")
    TreeUtilities.countPaths(root, 1) should be(1)

    Given("a complex tree")
    val t =
      new Tree(2
        ,
        new Tree(3,
          new Tree(2,
            new Tree(-2),
            new Tree(-2)),
          new Tree(6,
            null,
            new Tree(-6))
        ),
        new Tree(5,
          null,
          new Tree(-2)
        )
      )

    Then("it should find a path of sum 7")
    TreeUtilities.countPaths(t, 5) should be(5)
  }

  scenario("Test enumeration of paths") {
    Given("a tree node")
    val t =
      new Tree(2,
        new Tree(3,
          new Tree(2,
            new Tree(-2),
            new Tree(-2)),
          new Tree(6,
            null,
            new Tree(-6))
        ),
        new Tree(5,
          null,
          new Tree(-2)
        )
      )

    Then("it should find all the paths")
    TreeUtilities.findPaths(t, 5) should be(Seq(Seq(2, 3), Seq(2, 3, 2, -2), Seq(2, 3, 2, -2), List(2, 3, 6, -6), Seq(2, 5, -2)))
  }
}
