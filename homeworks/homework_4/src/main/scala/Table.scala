import scala.collection.mutable
class Table(width: Int, height: Int){
  val table: mutable.ArrayBuffer[Cell] = mutable.ArrayBuffer.fill(width * height)(new EmptyCell())
  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix < 0 || ix >= width || iy < 0 || iy >= height) None else Option(table(ix + iy * width))
  }
  def setCell(ix: Int, iy: Int, cell: Cell): Unit= {
    table(ix + iy * width) = cell
  }
}