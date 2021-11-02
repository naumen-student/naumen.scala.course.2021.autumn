import scala.annotation.tailrec
import scala.collection.immutable.HashSet
trait Cell

class EmptyCell() extends Cell{
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell{
  override def toString: String = number.toString
}

class StringCell(strValue: String) extends Cell{
  override def toString: String = strValue
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell{
  private val refTable = table
  private val x = ix
  private val y = iy

  override def toString: String = {
    @tailrec
    def toStringRecursive(cell: ReferenceCell, visited: HashSet[Cell]) : String =
      cell.refTable.getCell(cell.x,cell.y) match {
        case None => "outOfRange"
        case Some(nextCell : ReferenceCell) => if(visited.contains(nextCell)) "cyclic" else toStringRecursive(nextCell,visited + nextCell)
        case Some(nextNotRefCell : Cell) =>  nextNotRefCell.toString
      }

    toStringRecursive(this, HashSet.empty[Cell])
  }
}

