package ro.redeul.katas.algos

object IslandProfile {

  case class Wall(pos: Float, height: Int, len: Float) {
    val end = pos +len
  }

  def _waterVolume(topLeft: Wall, bottomLeft: Wall, topRight: (Float, Int)) = {
    (bottomLeft.len - topLeft.end + topRight._1) * (topLeft.height - bottomLeft.height) / 2
  }

  def waterVolume(profile: Seq[(Int, Int)]): Float = {

    def computeVolume(profile: Seq[(Int, Int)], leftWalls: Seq[Wall], vol: Float): Float = {
      (profile, leftWalls) match {
        case (Nil, _) => vol

        case ((pos, height) :: pTail, Nil) =>
          computeVolume(pTail, Seq(Wall(pos, height, 0.0f)), vol)

        case ((pos, height) :: pTail, w :: wTail) if height < w.height =>
          computeVolume(pTail, Wall(pos, height, 0) +: leftWalls, vol)

        case ((pos, height) :: pTail, w :: wTail) if height >= w.height =>

          wTail match {
            case Nil => computeVolume(pTail, Seq(Wall(pos, height, 0)), vol)

            case _w :: wTailTail if height < _w.height =>

              val intersectionX = _w.end + (w.pos - _w.end) * (_w.height - height) / (_w.height - w.height)

              val wallHead = Wall(intersectionX, height, pos - intersectionX)
              val waterVolume = _waterVolume(Wall(intersectionX, height, 0), w, (pos, height))

              computeVolume(pTail, wallHead +: wTail, vol + waterVolume)

            case _w :: wTailTail if height > _w.height =>
              val intersectionX = w.end + (pos - w.end) * (_w.height - w.height) / (height - w.height)

              val wallHead = Wall(_w.pos, _w.height, intersectionX - _w.pos)
              val waterVolume = _waterVolume(_w, w, (intersectionX, height))

              computeVolume((pos, height) :: pTail, wallHead +: wTailTail, vol + waterVolume)

            case _w :: wTailTail if height == _w.height =>
              val wallHead = Wall(_w.pos, _w.height, pos - _w.pos)
              val waterVolume = _waterVolume(_w, w, (pos, height))

              computeVolume(pTail, wallHead +: wTailTail, vol + waterVolume)
          }
      }
    }

    computeVolume(profile, Nil, 0)
  }
}
