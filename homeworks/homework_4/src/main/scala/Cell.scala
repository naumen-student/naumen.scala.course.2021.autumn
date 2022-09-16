import scala.annotation.tailrec

sealed trait Cell

object Cell {
  val empty = new EmptyCell
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}
case class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}
case class StringCell(string: String) extends Cell {
  override def toString: String = string
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = findReferenceValue(this, Set.empty)

  @tailrec
  private def findReferenceValue(currentCell: ReferenceCell, visited: Set[(Int, Int)]): String =
    table.getCell(currentCell.ix, currentCell.iy) match {
      case Some(cell) =>
        cell match {
          case nextCell: ReferenceCell =>
            if (visited.contains((nextCell.ix, nextCell.iy)))
              "cyclic"
            else
              findReferenceValue(nextCell, visited + (ix -> iy))
          case c: Cell => c.toString
        }
      case None => "outOfRange"
    }
}
