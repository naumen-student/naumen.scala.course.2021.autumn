trait  Cell {
  def toString: String
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString()
}

class StringCell(string: String) extends Cell {
  override def toString: String = string
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = getStringValue(List.empty)

  def getStringValue(visited: Seq[ReferenceCell]): String = {
    table.getCell(ix, iy).get match {
      case referenceCell: ReferenceCell =>
        if (visited.contains(this))
          "cyclic"
        else
          referenceCell.getStringValue(this +: visited)
      case cell: Cell => cell.toString
      case _ => "outOfRange"
    }
  }
}