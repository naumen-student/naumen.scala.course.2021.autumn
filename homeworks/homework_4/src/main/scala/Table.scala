// я пока разбор не смотрел, посмотрю как сдам задание)
import scala.collection.{immutable, mutable}

class Table(val width: Int, val height: Int) {
  private val content = new mutable.HashMap[(Int, Int), Cell]().withDefaultValue(EmptyCell())

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if (isOutOfRange(ix, iy)) {
      None
    } else {
      Some(content((ix, iy)))
    }
  }

  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    content.put((ix, iy), cell);
  }

  def isOutOfRange(ix: Int, iy: Int): Boolean = {
    ix < 0 || iy < 0 || ix >= width || iy >= height
  }
}