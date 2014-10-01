package ro.redeul

import ro.redeul.detector.fs.{File, FileSystem}

object FileUtilities {

  def weakHash(f: File)(implicit fs: FileSystem): String = ""

  def compareContent(f1: File, f2: File)(implicit fs:FileSystem): Boolean = true

}
