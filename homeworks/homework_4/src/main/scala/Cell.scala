import scala.collection.mutable

trait Cell

case class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

case class NumberCell(value: Int) extends Cell {
  override def toString: String = value.toString
}

case class StringCell(value: String) extends Cell {
  override def toString: String = value
}

case class ReferenceCell(x: Int, y: Int, table: Table) extends Cell {
  override def toString: String = {
    val visitedCells = mutable.HashSet[ReferenceCell]()
    var nextCell = table.getCell(x, y).getOrElse("outOfRange")

    while (nextCell.isInstanceOf[ReferenceCell]) {
      val nextCellAsReferenced = nextCell.asInstanceOf[ReferenceCell]
      if (visitedCells.contains(nextCellAsReferenced)) return "cyclic"
      visitedCells += nextCellAsReferenced
      nextCell = table.getCell(nextCellAsReferenced.x, nextCellAsReferenced.y).getOrElse("outOfRange")
    }
    nextCell.toString
  }
}
