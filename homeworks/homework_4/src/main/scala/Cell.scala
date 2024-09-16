import scala.collection.immutable.HashSet

case class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

sealed trait Cell

case class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

case class StringCell(string: String) extends Cell {
  override def toString: String = string
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = toStringInternal(this, HashSet.empty[Cell])

  private def toStringInternal(cell: ReferenceCell, visited: HashSet[Cell]): String = {
    getCellInReference(cell) match {
      case None => "outOfRange"
      case Some(nextCell) => nextCell match {
        case refCell: ReferenceCell =>
          if (visited.contains(refCell)) "cyclic"
          else toStringInternal(refCell, visited + refCell)
        case _ => nextCell.toString
      }
    }
  }

  private def getCellInReference(cell: ReferenceCell): Option[Cell] = cell.table.getCell(cell.ix, cell.iy)
}