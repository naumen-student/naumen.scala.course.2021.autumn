class Table(val width: Int, val len: Int){
  private val content = Array.ofDim[Cell](width, len)
  for (i <- 0 until width) {
    for (j <- 0 until len) {
      content(i)(j) = new EmptyCell()
    }
  }

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (ix < 0 || ix > width || iy < 0 || iy > len) return None
    Option(content(ix)(iy))
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    content(ix)(iy) = cell
  }
}