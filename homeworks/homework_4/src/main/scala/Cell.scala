trait  Cell {
  def toString: String
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(content: Int) extends Cell {
  override def toString: String = content.toString
}

class StringCell(content: String) extends Cell {
  override def toString: String = content
}

class ReferenceCell(x: Int, y: Int, table: Table) extends Cell {
  override def toString: String = findSource(List.empty)

  def findSource(visited: Seq[Cell]): String = {
    table.get(x, y).get match {
      case referenceCell: ReferenceCell =>
        if (visited.contains(this))
          "cyclic"
        else
          referenceCell.findSource(visited :+ this)
      case cell: Cell => cell.toString
      case _ => "outOfRange"
    }
  }
}
