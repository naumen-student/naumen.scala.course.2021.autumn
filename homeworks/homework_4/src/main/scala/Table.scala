class Table(width: Int, height: Int){
  private val cells: Array[Cell] = Array.fill[Cell](width * height)(new EmptyCell)

  private def inBounds(x: Int, y: Int) : Boolean = (0 <= x && x < width && 0 <= y && y < height)

  def getCell(x: Int, y: Int): Option[Cell] = if (inBounds(x,y)) Some(cells(x + y * width)) else None

  def setCell(x: Int, y: Int, cell: Cell): Unit = if (inBounds(x,y)) cells(x + y * width) = cell
}