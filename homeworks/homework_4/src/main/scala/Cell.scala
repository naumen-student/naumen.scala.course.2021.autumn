trait Cell {}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(val value: Int) extends Cell {
  override def toString: String = value.toString
}

class StringCell(val value: String) extends Cell {
  override def toString: String = value
}

class ReferenceCell(val x: Int, val y: Int, val table: Table) extends Cell {
  def cell: Cell = {
    if (table.getCell(x, y) == Option.empty)
      new StringCell("outOfRange")
    else
      table.getCell(x, y) match {
        case None => throw new NotImplementedError()
        case Some(c: Cell) => c
      }
  }
  override def toString: String = {
    var currentCell = this.cell
    while (currentCell.isInstanceOf[ReferenceCell]) {
      if (currentCell.asInstanceOf[ReferenceCell].x == x && currentCell.asInstanceOf[ReferenceCell].y == y) {
        currentCell = new StringCell("cyclic")
      }
      else
        currentCell = currentCell.asInstanceOf[ReferenceCell].cell
    }
    currentCell.toString
  }
}