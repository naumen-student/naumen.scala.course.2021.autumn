trait Cell {
  def toString: String
}

class EmptyCell extends Cell {
  override def toString: String = "empty"
}

class NumberCell(n: Int) extends Cell {
  override def toString: String = n.toString
}

class StringCell(str: String) extends Cell {
  override def toString: String = str
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = toStringImpl(Seq())

  def toStringImpl(references: Seq[ReferenceCell]): String = {
    val tableCell = table.getCell(ix, iy)
    tableCell match {
      case Some(refCell: ReferenceCell) => {
        if (!references.contains(this))
          refCell.toStringImpl(this +: references)
        else "cyclic"
      }
      case Some(someCell: Cell) => someCell.toString
      case _ => "outOfRange"
    }
  }
}