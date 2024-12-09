class Table(width: Int, height: Int)
{
  private val  myMatrix : Array[Cell] =  Array.fill[Cell](width*height)(new EmptyCell)
  println(myMatrix.mkString("Array(", ", ", ")"))

  def isInBounds(ix: Int, iy: Int) : Option[Boolean] =
  {
    val res = (ix > -1 && ix < width && iy > -1 && iy < height)
    if (res) Some(res) else None
  }
  def setCell(ix: Int, iy: Int, cell: Cell): Unit =
  {
    isInBounds(ix, iy).foreach(_=>myMatrix(ix+iy*width) = cell)
  }
  def getCell(ix: Int, iy: Int): Option[Cell] =
  {
    isInBounds(ix, iy).map(_=>myMatrix(ix+iy*width))
  }
}