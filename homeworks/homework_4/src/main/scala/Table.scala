class Table(val height:Int, val width:Int) {
  private val Cell: Array[Array[Cell]] = Array.fill(height, width)(new EmptyCell)

  def getCell(x: Int, y: Int): Option[Cell] =
    if (isCellPositionCorrect(x, y))
      Some(Cell(y)(x))
    else None

  def setCell(x: Int, y: Int, cell: Cell): Unit = {
    assert(isCellPositionCorrect(x, y))
    Cell(y)(x) = cell
  }

  def isCellPositionCorrect(x:Int,y:Int):Boolean =
    !(x >= width || y >= height || x < 0 || y < 0)
}