class Table(width: Int, height: Int)
{
  val table: Array[Cell] = Array.fill(width * height)(new EmptyCell)

  def isValidCoordinates(ix: Int, iy: Int): Boolean = ix >= 0 && iy >= 0 && ix <= width && iy <= height

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (isValidCoordinates(ix, iy))
      Some (table(ix + iy * width))
    else
      None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (isValidCoordinates(ix, iy))
      table(ix + iy * width) = cell
  }
}