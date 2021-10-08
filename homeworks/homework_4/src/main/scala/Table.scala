class Table(val weight: Int, val height: Int) {
  private val cells: Array[Cell] = Array.fill(weight * height)(new EmptyCell())

  private def inBounds(position: Int, upperBound: Int): Boolean = {
    -1 < position && position < upperBound
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (inBounds(ix, weight) && inBounds(iy, height)) {
      Some(cells(ix + iy * weight))
    } else {
      None
    }
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (inBounds(ix, weight) && inBounds(iy, height)) {
      cells(ix + iy * weight) = cell
    }
  }
}
