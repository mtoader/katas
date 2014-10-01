import org.scalatest.{GivenWhenThen, Matchers, FeatureSpec}
import ro.redeul.detector.fs.{TestFileSystem, FileSystem, File}
import ro.redeul.DuplicateFileFinder


class DuplicateFileFinderTest extends FeatureSpec with GivenWhenThen with Matchers {

  info("As a duplicate checker")

  scenario("Basic functionality") {
    Given("a file system with similar files")
    implicit val fs: FileSystem = TestFileSystem()
      .addFile("/a/a", "test")
      .addFile("/a/b/b", "test")
      .addFile("/a/b/c/c", "test")
      .addFile("/a/b/c/d/d", "test")
      .addFile("/b", "b")
      .addFile("/c", "c")
      .addFile("/d", "d")

    Then("we should find the duplicates")
    DuplicateFileFinder.findDuplicates("/a") should be(Seq(Seq("/a/a", "/a/b/b", "/a/b/c/c", "/a/b/c/d/d")))
  }
}
