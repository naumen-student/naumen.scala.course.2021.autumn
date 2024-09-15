import scala.collection.mutable

class Table(width: Int, height: Int) {
  val array: Array[Cell] = new Array[Cell](width * height).map(_ => EmptyCell())
  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix >= 0 && ix < width && iy >= 0 && iy < height) Option(array(ix + iy*width))
    else None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = array(ix + iy*width) = cell
}