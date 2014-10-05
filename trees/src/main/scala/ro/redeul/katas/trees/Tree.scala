package ro.redeul.katas.trees

case class Tree(data: Int, left: Tree = null, right: Tree = null) {
  override def toString:String = {
    this match {
      case Tree(d, null, null) => "%d".format(d)
      case Tree(d, l, null) => "(%d, %s, _)".format(d, l.toString())
      case Tree(d, null, r) => "(%d, _, %s)".format(d, r.toString())
      case Tree(d, l, r) => "(%d, %s, %s)".format(d, l.toString(), r.toString())
    }
  }
}

