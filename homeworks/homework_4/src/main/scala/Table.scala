import scala.collection.mutable

class Table(val width: Int, val height: Int) {
  private val table: mutable.ArrayBuffer[Cell] = mutable.ArrayBuffer.fill(width * height)(new EmptyCell())

  private def isOutTable(ix: Int, iy: Int): Boolean = {
    ix < 0 || iy < 0 || ix >= width || iy >= height
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (isOutTable(ix, iy)) {
      None
    } else {
      Option(table(ix + iy * width))
    }
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    table(ix + iy * width) = cell
  }
}