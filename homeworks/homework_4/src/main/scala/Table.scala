import scala.Array.ofDim

class Table(val width: Int, val height: Int) {
  private val cells = ofDim[Cell](width, height)

  def getCell(row: Int, column: Int) = {
    if (row >= width || column >= height || row <= -1 || column <= -1)
      None
    else if (cells(row)(column) == null)
      Option(new EmptyCell)
    else
      Option(cells(row)(column)) //Почему нельзя вернуть просто Cell
  }

  def setCell(row: Int, column: Int, cell: Cell) = cells(row)(column) = cell
}