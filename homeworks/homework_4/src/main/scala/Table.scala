class Table(val width: Int, val height: Int) {
  private val table = Array.fill[Cell](height, width)(new EmptyCell)

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix >= height || ix < 0)
      return Option.empty

    if (iy >= width || iy < 0)
      return Option.empty

    Option(table(ix)(iy))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = table(ix)(iy) = cell

}