class Table(x: Int, y: Int) {
  private val cells: Array[Cell] = Array.fill[Cell](x * y)(new EmptyCell)

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix > -1 && ix < x && iy > -1 && iy < y) {
      Some(cells(ix + iy * x))
    }
    else {
      None
    }
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (ix > -1 && ix < x && iy > -1 && iy < y) {
      cells(ix + iy * x) = cell
    }
  }
}