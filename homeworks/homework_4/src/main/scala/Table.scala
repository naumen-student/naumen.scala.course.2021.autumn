import scala.collection.mutable.ArrayBuffer

class Table(val width: Int, val height: Int ){
  private val table: ArrayBuffer[Cell] = ArrayBuffer.tabulate(width * height)(n => new EmptyCell());

  def getCell(x: Int, y: Int): Option[Cell] = {
    if (x < 0 || x > width - 1 || y < 0 || y > height - 1) Option.empty else Some(this.table(x + y * width))
  }

  def setCell(x: Int, y: Int, cell: Cell): Unit = {
    table(x + y * width) = cell
  }

}