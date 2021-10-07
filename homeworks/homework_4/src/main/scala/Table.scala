import scala.Array._

class Table(val wight: Int, val height: Int){
  private val table = ofDim[Cell](height ,wight)
  for (y <- 0 until height){
    for (x <- 0 until wight){
      table(y)(x) = new EmptyCell
    }
  }

  def inBound(ix: Int, iy: Int): Boolean = {
    ix >= 0 && ix < wight && iy >= 0 && iy < height
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if(inBound(ix, iy)) {
      Some(table(iy)(ix))
    }
    else{
      None
    }
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit ={
    table(iy)(ix) = cell
  }
}
