package ro.redeul.katas.trees

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}
import ro.redeul.katas.trees.TreeUtilities.{balanceTree, findPaths, countPaths}

class TreeUtilitiesTest extends FeatureSpec with GivenWhenThen with Matchers {

  scenario("Testing counting of root paths") {
    Given("a one node tree")
    val root = new Tree(1)

    Then("it should find a path of sum 1")
    countPaths(root, 1) should be(1)

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

    Then("it should 5 paths of sum 5")
    countPaths(t, 5) should be(5)
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

    Then("it should enumerate 5 paths of sum 5")
    findPaths(t, 5) should be(Seq(Seq(2, 3), Seq(2, 3, 2, -2), Seq(2, 3, 2, -2), List(2, 3, 6, -6), Seq(2, 5, -2)))
  }

  scenario("balancing plates") {
    Given("A shaky tree")

    val t =
      new Tree(0,
        new Tree(0,
          new Tree(6),
          new Tree(2,
            new Tree(4),
            new Tree(8)
          )
        ),
        new Tree(100)
      )

    Then("balancing should change the weights")
    balanceTree(t, 5) should be(Some(new Tree(0, new Tree(34, new Tree(28), new Tree(2, new Tree(8), new Tree(8))), new Tree(100))))
  }
}
