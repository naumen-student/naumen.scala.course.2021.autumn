import scala.collection._

class Table(w: Int, h: Int) {
  private val table = mutable
    .Map[(Int, Int), Cell]()
    .withDefaultValue(new EmptyCell)

  def getCell(x: Int, y: Int): Option[Cell] = {
    if (notOutInRange(x, y)) {
      Some(table((x, y)))
    } else None
  }

  def setCell(x: Int, y: Int, cell: Cell): Unit = {
    if (notOutInRange(x, y)) {
      table.put(
        (x, y),
        cell
      )
    }
  }

  protected val notOutInRange:
    (Int, Int) => Boolean = {
    (x: Int, y: Int) => {
      x >= 0 && x < w &&
      y >= 0 && y < h
    }
  }
}