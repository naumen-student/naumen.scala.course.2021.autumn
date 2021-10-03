import scala.collection.mutable

class Table(width: Int, height: Int) {

  private val totalLength = width * height
  private val cells: mutable.ArraySeq[Cell] = mutable.ArraySeq.fill(totalLength)(Cell.empty)

  def getCell(ix: Int, iy: Int): Option[Cell] = getTableExistingIdx(ix, iy).map(cells)

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = getTableExistingIdx(ix, iy).foreach(cells(_) = cell)

  private def getTableExistingIdx(ix: Int, iy: Int): Option[Int] = {
    val idx = ix + iy * width
    if (idx < totalLength && idx > -1) Some(idx) else None
  }
}
