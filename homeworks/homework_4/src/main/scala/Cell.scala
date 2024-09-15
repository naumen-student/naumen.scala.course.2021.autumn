sealed trait Cell
{
  def toString: String
}

case class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

case class StringCell(str: String) extends Cell {
  override def toString: String = str
}

case class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = {
    try {
      table.getCell(ix, iy) match {
        case Some(referenceCell: ReferenceCell) => referenceCell.toString
        case Some(v) => v.toString
        case None => "outOfRange"
      }
    } catch {
      case a: StackOverflowError => "cyclic"
    }
  }
}
