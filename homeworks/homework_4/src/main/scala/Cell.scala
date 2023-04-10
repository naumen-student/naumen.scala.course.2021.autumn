trait Cell {
  def toString(): String
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(val value: Int) extends Cell {
  override def toString: String = value.toString
}

class StringCell(val value: String) extends Cell {
  override def toString: String = value.toString
}

class ReferenceCell(val row: Int, val column: Int, val table: Table) extends Cell {
  override def toString: String = {
    val cell = table.getCell(row, column)
    cell match {
      case Some(r: ReferenceCell) =>
        if (r.table.getCell(r.row, r.column) == Option(this)) "cyclic"
        else r.toString
      case None => "outOfRange"
      case Some(c) => c.toString
    }
  }
}