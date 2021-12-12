trait Cell {}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}
}

class StringCell(string: String) extends Cell {
  override def toString: String = string
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  private def tryGetNextCell: Option[Cell] = table.getCell(ix, iy)
  override def toString: String = {
    table.getCell(ix, iy) match {
      case None => "outOfRange"
      case Some(cell: ReferenceCell) => if (cell.tryGetNextCell.contains(this)) "cyclic" else cell.toString
      case Some(cell: Cell) => cell.toString
    }
  }
}