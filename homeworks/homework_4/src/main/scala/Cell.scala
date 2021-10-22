trait Cell {
  override def toString: String = super.toString
}

class EmptyCell() extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

class StringCell(string: String) extends Cell {
  override def toString: String = string
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  private def referencedCell: Option[Cell] = table.getCell(ix, iy)

  override def toString: String = {
    referencedCell match {
      case None => "outOfRange"
      case Some(cell : ReferenceCell) => if (cell.referencedCell.contains(this)) "cyclic" else cell.toString
      case other => other.get.toString
    }
  }
}
