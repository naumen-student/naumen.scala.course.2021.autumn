trait Cell{
  def toString: String
}

class StringCell(text: String) extends Cell {
  override def toString: String = text
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class ReferenceCell(var ix: Int, var iy: Int, table: Table) extends Cell {
  override def toString: String = {
    table.getCell(ix, iy) match {
      case Some(cell: ReferenceCell) =>
        val cellOrNone = checkCyclic(cell)
        if (cellOrNone.isEmpty)
          "cyclic"
        else
          cellOrNone.get.toString
      case Some(cell: Cell) => cell.toString
      case None => "outOfRange"
    }
  }

  def checkCyclic(cell: ReferenceCell): Option[Cell] = {
    val newCell = table.getCell(cell.ix, cell.iy)
    newCell match {
      case Some(c: ReferenceCell) =>
        if(c.ix == ix && c.iy == iy)
          None
        else
          checkCyclic(c)
      case _ => newCell
    }
  }
}