class Table(var width: Int, var height: Int){

  private var table: Array[Cell] = Array.fill(width* height) {new EmptyCell}

  def getCell(ix: Int, iy: Int): Option[Cell] =
    if(ix <= width && ix >= 0 && iy <= height && iy >= 0)
      Some(table.apply(ix + iy * width))
    else None

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = table(ix + iy * width) = cell

}