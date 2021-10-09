import scala.annotation.tailrec
import scala.collection.immutable.HashSet

trait Cell

//лучше было сделать так, но поскольку в тестах new, написала по-другому
//case object EmptyCell extends Cell{
//  override def toString: String = "empty"
//}

case class EmptyCell() extends Cell{
  override def toString: String = "empty"
}

case class NumberCell(number: Int) extends Cell{
  override def toString: String = number.toString
}

case class StringCell(string: String) extends Cell{
  override def toString: String = string
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell{
  override def toString: String = refToString(HashSet.empty[Cell], this)

  @tailrec
  private def refToString(visited: HashSet[Cell], ref: ReferenceCell): String =
    if (visited.contains(ref))
      "cyclic"
    else
      ref.table.getCell(ref.ix, ref.iy) match {
        case None => "outOfRange"
        case Some(c@(EmptyCell()|NumberCell(_)| StringCell(_))) => c.toString
        case Some(referenceCell: ReferenceCell) => refToString(visited+ref, referenceCell)
      }
}