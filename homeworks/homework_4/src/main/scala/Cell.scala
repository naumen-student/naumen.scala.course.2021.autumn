trait Cell {}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(val number: Int) extends Cell {
  override def toString: String = number.toString
}

class StringCell(val string: String) extends Cell {
  override def toString: String = string
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  private def takeNext: Option[Cell] = table.getCell(ix, iy)
  override def toString: String = {
    table.getCell(ix, iy) match {
      case None => "outOfRange"
      case Some(cell: ReferenceCell) => if (!cell.takeNext.contains(this)) cell.toString else "cyclic"
      case Some(cell: Cell) => cell.toString
    }
  }
}