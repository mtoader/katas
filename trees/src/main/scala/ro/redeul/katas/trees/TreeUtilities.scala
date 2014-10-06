package ro.redeul.katas.trees

import scala.annotation.tailrec

object TreeUtilities {

  def countPaths(node: Tree, target: Int): Int = {
    val delta = target - node.data

    (if (delta == 0) 1 else 0) + (node match {
      case Tree(_, null, null) => 0
      case Tree(_, l, null) => countPaths(l, delta)
      case Tree(_, null, r) => countPaths(r, delta)
      case Tree(_, l, r) => countPaths(l, delta) + countPaths(r, delta)
    })
  }

  def findPaths(n: Tree, target: Int): Seq[Seq[Int]] = {

    def _findPaths(n: Tree, target: Int, path: Seq[Int]): Seq[Seq[Int]] = {

      val newPath = path :+ n.data

      val delta = target - n.data
      (if (delta == 0) Seq(newPath) else Nil) ++ (n match {
        case Tree(_, null, null) => Nil
        case Tree(_, l, null) => _findPaths(l, delta, newPath)
        case Tree(_, null, r) => _findPaths(r, delta, newPath)
        case Tree(_, l, r) => _findPaths(l, delta, newPath) ++ _findPaths(r, delta, newPath)
      })
    }

    _findPaths(n, target, Nil)
  }

  def balanceTree(t: Tree, plateWeight: Int): Option[Tree] = {
    def _balance(n: Tree): Option[(Int, Tree)] = {
        n match {
          case Tree(w, null, null) => Some(w -> n)
          case Tree(w, _l, _r) if _l != null && _r != null =>
            _balance(_l) flatMap {
              case (lWeight, lNode) =>
                _balance(_r) map {
                  case (rWeight, rNode) =>
                    if (lWeight < rWeight)
                      (rWeight, new Tree(lNode.data + (rWeight - lWeight), lNode.left, lNode.right), rNode)
                    else
                      (lWeight, lNode, new Tree(rNode.data + (lWeight - rWeight), rNode.left, rNode.right))
                }
            } map {
              case (maxChildWeight, lNode, rNode) =>
                w + 2 * (maxChildWeight + plateWeight) -> new Tree(w, lNode, rNode)
            }
          case _ => None
        }
    }

    _balance(t) map { case (w, tree) => tree }
  }

  def traverse(node: Tree): Seq[Int] = {
    node match {
      case null => Nil
      case Tree(data, left, right) => (traverse(left) :+ data) ++ traverse(right)
    }
  }

  def nonRecursiveTraversal(node: Tree): Seq[Int] = {

    @tailrec
    def _traverse(node: Tree, pending: Seq[Tree], output: Seq[Int]): Seq[Int] = {
      node match {
        case Tree(d, null, null) =>
          pending match {
            case Nil => output :+ d
            case h :: t => _traverse(h, t, output :+ d)
          }

        case Tree(d, null, r) => _traverse(r, pending, output :+ d)
        case Tree(d, l, r) => _traverse(l, node.copy(left = null) +: pending, output)
      }
    }

    _traverse(node, Seq(), Seq())
  }
}
