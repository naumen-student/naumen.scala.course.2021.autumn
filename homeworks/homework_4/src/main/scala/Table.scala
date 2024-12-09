class Table(width: Int, height: Int)
{
  private val table: Array[Array[Cell]] = Array.fill(width)(Array.fill(height)(new EmptyCell))

  def get(x: Int, y: Int): Option[Cell] = {
    if (isValidCoordinates(x, y))
      Some (table(x)(y))
    else
      None
  }

  def set(x: Int, y: Int, cell: Cell): Unit = {
    if (isValidCoordinates(x, y))
      table(x)(y) = cell
  }

  def isValidCoordinates(x: Int, y: Int): Boolean = x >= 0 && y >= 0 && x <= width && y <= height
}
