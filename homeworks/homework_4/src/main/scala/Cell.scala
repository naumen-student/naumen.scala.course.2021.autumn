import scala.annotation.tailrec
import scala.collection.immutable.HashSet

trait Cell

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = s"$number"
}

class StringCell(str: String) extends Cell {
  override def toString: String = str
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  private val refTable = table
  private val refX = ix
  private val refY = iy

  private def getCellByRef(cell: ReferenceCell): Option[Cell] = cell.refTable.getCell(cell.refX, cell.refY)

  override def toString: String = toStringInternal(this, HashSet[Cell]())

  @tailrec
  private def toStringInternal(cell: ReferenceCell, visited: HashSet[Cell]): String = {
    getCellByRef(cell) match {
      case None => "outOfRange"
      case Some(nextCell: ReferenceCell) =>
        if (!visited.contains(nextCell))
          toStringInternal(nextCell, visited + nextCell)
        else
          "cyclic"
      case Some(nextCell: Cell) => nextCell.toString
    }
  }
}