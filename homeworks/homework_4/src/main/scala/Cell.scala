trait Cell {
  def toString: String
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(num: Int) extends Cell {
  override def toString: String = num.toString
}

class StringCell(str: String) extends Cell {
  override def toString: String = str
}

class ReferenceCell(x: Int, y: Int, table: Table) extends Cell {
  override def toString: String = resolveCycles(Seq(this))

  def resolveCycles(previousCells: Seq[ReferenceCell]): String = {
    table.getCell(x, y) match {
      case None => "outOfRange"
      case optionalCell =>
        optionalCell.get match {
          case cell: ReferenceCell =>
            if (previousCells.contains(cell))
              "cyclic"
            else
              cell.resolveCycles(cell +: previousCells)
          case cell: Cell => cell.toString
        }
    }
  }
}