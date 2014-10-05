package ro.redeul.katas.trees

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
                      (rWeight, new Tree(rWeight, lNode.left, lNode.right), rNode)
                    else
                      (lWeight, lNode, new Tree(lWeight, rNode.left, rNode.right))
                }
            } map {
              case (max, lNode, rNode) => w + 2 * (max + plateWeight) -> new Tree(w, lNode, rNode)
            }
        }
    }
    _balance(t) map {
      _._2
    }
  }
}
