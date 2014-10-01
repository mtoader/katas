package ro.redeul

import ro.redeul.detector.fs.{File, FileSystem}

object DuplicateFileFinder {

  import Groupers._

  def findDuplicates(rootName: String)(implicit fs: FileSystem): Seq[Seq[String]] = {

    fs.resolve(rootName) map {
      getAllChildren(_, fs)
    } map {
      byFileSize
    } map {
      repartition(_, byWeakHash)
    } map {
      repartition(_, byContent)
    } map { 
      _ map { _ map { _.name } }
    } getOrElse Seq.empty[Seq[String]]
  }

  def getAllChildren(root: File, fs: FileSystem): Seq[File] = {
    PartialFunction.condOpt(root) {
      case f if f.folder => f
    } map {
      fs.listChildren(_).foldLeft(Seq.empty[File]) {
        case (s, f) => s ++ getAllChildren(f, fs)
      }
    } getOrElse Seq(root)
  }

  def repartition(inPartitions: Seq[Seq[File]], grouper: Groupers.Grouper): Seq[Seq[File]] = {
    inPartitions.foldLeft(Seq.empty[Seq[File]]) {
      case (outPartitions, partition) => outPartitions ++ grouper(partition)
    }
  }
}
