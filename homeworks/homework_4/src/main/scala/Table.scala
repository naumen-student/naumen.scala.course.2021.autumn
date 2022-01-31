
  class Table (width : Int, height : Int) {

  private var matrix = Array.ofDim[Cell](width, height)

  for (i <- 0 until width; j <- 0 until height) {
     matrix(i)(j) = new EmptyCell()
  }


  def getCell (ix: Int, iy: Int): Option[Cell] = {
    if (checkLocation (ix, iy))
      Some(matrix(ix)(iy)) else None
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    if (checkLocation(ix, iy))
     matrix(ix)(iy) = cell
  }

  def checkLocation (ix: Int, iy: Int ) : Boolean = {
    ix >= 0 &&  iy >= 0 && ix < width && iy < height
  }

}