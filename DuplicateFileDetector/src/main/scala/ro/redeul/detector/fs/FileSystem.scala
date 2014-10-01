package ro.redeul.detector.fs

trait File {
  def name: String

  def folder: Boolean

  def size: Long
}

trait FileSystem {

  def resolve(fileName: String): Option[File] = FileSystem.parseURI(fileName) flatMap {
    case (path, name) => _resolve(path, name)
  }

  def listChildren(file: File): Seq[File]

  def read(f: File, pos: Int, size: Int): Array[Byte]

  protected def _resolve(path: Seq[String], name: String): Option[File]
}

object FileSystem {

  def parseURI(uri: String): Option[(Seq[String], String)] = {
    val parts: Seq[String] = uri.split("/+").toSeq filter {
      _.length != 0
    }

    PartialFunction.condOpt(parts.toSeq) {
      case p if p.length > 0 => p
    } map {
      path => (path.take(path.length - 1).toSeq, path.takeRight(1).head)
    }
  }

  def makeURI(path: Seq[String], name: String): Option[String] =
    Some("/" + (path :+ name).mkString("/"))
}
