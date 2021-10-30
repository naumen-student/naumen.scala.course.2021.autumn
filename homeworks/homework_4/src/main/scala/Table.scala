class Table(width: Int, height: Int) {
  private var table: Array[Cell] = Array.fill(width * height) {new EmptyCell}

  def setCell(ix: Int, iy: Int, cell: Cell): Unit ={
    table(ix + iy * width) = cell
  }

  def getCell(ix: Int, iy: Int) : Option[Cell] =
    if(ix > -1 && ix < width && iy > -1 && iy < height)
      Some(table.apply(ix + iy * width))
    else
      None
}