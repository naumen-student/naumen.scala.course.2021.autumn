import scala.collection.mutable.ArrayBuffer

class Table(height: Int, width: Int){
  private val array = ArrayBuffer.tabulate[Cell](width * height)(_ => EmptyCell())

  private def getIndex(ix: Int, iy: Int): Int = ix + width * iy

  def getCell(ix: Int, iy: Int): Option[Cell] ={
    val index = getIndex(ix, iy)
    if (ix <0 || iy <0 || array.lengthCompare(index) <= 0) None
    else Some(array(index))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    val index = getIndex(ix, iy)
    if (ix >= 0 || iy >= 0 || array.lengthCompare(index) > 0)
      array(index) =  cell
  }
}