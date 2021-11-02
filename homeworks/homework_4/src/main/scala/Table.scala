import scala.collection.mutable.ListBuffer

class Table(width: Int, height: Int) {
  private val table : ListBuffer[Cell] = ListBuffer.fill[Cell](width * height){new EmptyCell};

  private def isIndexInRange(ix: Int, iy: Int): Boolean = ix >= 0 && ix < width && iy >= 0 && iy < height

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    Some(isIndexInRange(ix,iy))
      .filter(_ == true)
      .map(_ => table(ix + iy*width))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if(isIndexInRange(ix,iy)) table(ix + iy * width) = cell
  }

}