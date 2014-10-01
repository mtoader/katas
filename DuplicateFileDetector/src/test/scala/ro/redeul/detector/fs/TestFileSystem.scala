package ro.redeul.detector.fs

class TestFileSystem extends FileSystem {

  import FileSystem._

  type FileData = Array[Byte]

  type Dirent[T] = Map[String, Either[T, _]]

  var entries: Dirent[FileData] = Map.empty

  case class TestFile(name: String, size: Long) extends File {
    override val folder: Boolean = false
  }

  case class TestFolder(name: String) extends File {
    val folder: Boolean = true
    val size: Long = 0
  }

  override def read(f: File, pos: Int, size: Int): Array[Byte] = Array()

  override def listChildren(file: File): Seq[File] =
    parseURI(file.name) map {
      case (path, name) => path :+ name
    } flatMap {
      p => _resolveDirent(p, entries) map { d => (p, d)}
    } map {
      case (path, d) =>
        d.map {
          case (childName, Left(data)) => makeURI(path, childName) map {
            TestFile(_, data.length)
          }
          case (childName, Right(_)) => makeURI(path, childName) map {
            TestFolder
          }
        }
    } map {
      _.flatten.toSeq
    } getOrElse Seq()

  override protected def _resolve(path: Seq[String], name: String): Option[File] =
    _resolveDirent(path, entries) flatMap {
      _.get(name)
    } flatMap {
      e => makeURI(path, name) map { uri =>
        e.fold(
          f => TestFile(uri, f.length),
          d => TestFolder(uri)
        )
      }
    }

  private def _resolveDirent[T](path: Seq[String], entries: Dirent[T]): Option[Dirent[T]] =
    path.toList match {
      case Nil => Some(entries)
      case h :: tail =>
        for (
          e <- entries.get(h);
          headEntry <- foldToDirent(e);
          tailEntry <- _resolveDirent(tail, headEntry)) yield tailEntry
    }

  private def foldToDirent[T](either: Either[T, _]): Option[Dirent[T]] = either.fold(_ => None, r => Some(r.asInstanceOf[Dirent[T]]))

  private def foldToData[T](either: Either[T, _]): Option[T] = either.fold(l => Some(l), _ => None)

  def addFile(fileName: String, content: String): TestFileSystem = {
    parseURI(fileName) map {
      case (p, name) =>
        entries = _addToDirent(p, name, content, entries) getOrElse entries
    }

    this
  }

  private def _addToDirent(path: Seq[String], name: String, content: String, entries: Dirent[FileData]): Option[Dirent[FileData]] = {
    path.toList match {
      case Nil =>
        entries.get(name) match {
          case None | Some(Left(_)) => Some(entries + (name -> Left(content.getBytes("UTF-8"))))
          case Some(Right(_)) => None
        }

      case h :: tail =>
        (entries.get(h) match {
          case None => Some(Map.empty[String, Either[FileData, _]])
          case Some(Right(d)) => Some(d.asInstanceOf[Dirent[FileData]])
          case _ => None
        }) flatMap {
          _addToDirent(tail, name, content, _)
        } map {
          d => entries + (h -> Right(d))
        }
    }
  }
}

object TestFileSystem {
  def apply(): TestFileSystem = new TestFileSystem()
}
