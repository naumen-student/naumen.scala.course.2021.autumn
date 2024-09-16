import scala.collection.mutable

class Table(width: Int, height: Int) {
  private val cells : mutable.IndexedSeq[Cell] = mutable.IndexedSeq.fill(width * height) {EmptyCell()}

  private def convertToIndex(ix: Int, iy: Int): Int = ix + iy * width

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    val index = convertToIndex(ix, iy)
    if (index >= 0 && index < cells.length) Some(cells(index))
    else None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    cells.update(convertToIndex(ix, iy), cell)
  }
}