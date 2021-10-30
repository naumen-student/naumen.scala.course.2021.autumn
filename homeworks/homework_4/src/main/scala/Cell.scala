trait Cell{
  def toString: String
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell{
  override def toString: String = number.toString
}

class StringCell(line: String) extends Cell{
  override def toString: String = line
}

class ReferenceCell(var ix: Int, var iy: Int, table: Table) extends Cell{
  override def toString: String = {
    table.getCell(ix, iy) match {
      case Some(cell: ReferenceCell) =>
        val cellOrNone = check(cell)
        if (cellOrNone.isEmpty)
          "cyclic"
        else
          cellOrNone.get.toString
      case Some(cell: Cell) => cell.toString
      case None => "outOfRange"
    }
  }

  def check(cell: ReferenceCell): Option[Cell] = {
    val newCell = table.getCell(cell.ix, cell.iy)
    newCell match {
      case Some(c: ReferenceCell) =>
        if(c.iy == iy && c.ix == ix)
          None
        else
          check(c)
      case _ => newCell
    }
  }
}