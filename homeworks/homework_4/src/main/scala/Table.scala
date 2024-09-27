class Table(height: Int, width: Int) {
  private val table = Array.fill[Cell](height * width)(new EmptyCell)
  private def isInRange(ix: Int, iy: Int): Boolean = ix >= 0 && ix < width && iy >= 0 && iy < height

  def getCell(ix: Int, iy: Int): Option[Cell] = Some(isInRange(ix, iy))
    .filter(_ == true)
    .map(_ => table.apply(ix + iy * width))

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (isInRange(ix, iy))
      table(ix + iy * width) = cell
  }
}