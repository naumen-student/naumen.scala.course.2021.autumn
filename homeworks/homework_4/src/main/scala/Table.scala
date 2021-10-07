import scala.collection.mutable.ArrayBuffer

class Table(width: Int, height: Int) {
  private val cells = ArrayBuffer.fill[Cell](width * height)(new EmptyCell)

  private def checkIndex(ix: Int, iy: Int): Boolean = {
    0 <= ix && 0 <= iy && ix < width && iy < height
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (checkIndex(ix, iy))
      Some(cells(ix + iy * width))
    else None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (checkIndex(ix, iy))
      cells(ix + iy * width) = cell
  }
}
