// я пока разбор не смотрел, посмотрю как сдам задание)
import scala.annotation.tailrec
import scala.collection.immutable

sealed trait Cell

case class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

case class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

case class StringCell(text: String) extends Cell {
  override def toString: String = text
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = toString(immutable.Set[ReferenceCell]());

  @tailrec
  private def toString(visited: immutable.Set[ReferenceCell]): String = {
    if (visited.contains(this)) "cyclic"
    else table.getCell(ix, iy) match {
      case None => "outOfRange"
      case Some(refCell: ReferenceCell) => refCell.toString(visited + this)
      case Some(cell) => cell.toString
    }
  }
}