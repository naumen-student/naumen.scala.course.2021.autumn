class Table(height: Int, width: Int) {
  private val array: Array[Cell] = new Array[Cell](width * height).map(_ => new EmptyCell)

  def getCell(x: Int, y: Int): Option[Cell] = if (x < 0 || y < 0 || x >= height || y >= width) Option.empty else Option(array(x + y * width))

  def setCell(x: Int, y: Int, cell: Cell): Unit = array(x + y * width) = cell
}
