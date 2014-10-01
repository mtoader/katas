package ro.redeul

import ro.redeul.detector.fs.{File, FileSystem}


object Groupers {

  import FileUtilities._

  type Grouper = (Seq[File]) => Seq[Seq[File]]

  private def groupBy[T](files: Seq[File])(groupKey: (File) => T): Seq[Seq[File]] =
    (files.foldLeft(Map.empty[T, Seq[File]]) {
      case (m, f) =>
        val key = groupKey(f)
        m + (key -> (m.getOrElse(key, Seq.empty[File]) :+ f))
    } map {
      _._2
    } filter {
      _.size > 1
    }).toSeq

  def byFileSize: Grouper = groupBy(_) { _.size }

  def byWeakHash(files: Seq[File])(implicit fs:FileSystem): Seq[Seq[File]] = groupBy(files)(weakHash)

  def byContent(files: Seq[File])(implicit fs:FileSystem): Seq[Seq[File]] = {

    val (similar, different) = files.tail.partition {
      compareContent(files.head, _)
    }

    val same = files.head +: similar
    if (different.size <= 1) Seq(same) else same +: byContent(different)
  }
}