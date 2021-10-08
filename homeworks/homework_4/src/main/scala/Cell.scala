trait Cell

class EmptyCell extends Cell {
  override def toString : String = "empty"
}

class NumberCell(num: Int) extends Cell {
  override def toString: String = num.toString
}

class StringCell(str: String) extends Cell {
  override def toString: String = str
}

class ReferenceCell(x: Int, y: Int, table: Table) extends Cell {
  override def toString: String = refToString(Nil)

  private def refToString(refs: Seq[ReferenceCell]): String = {
    table.getCell(x, y).map {
      case rCell: ReferenceCell =>
        if (!refs.contains(this)) rCell.refToString(this +: refs) else "cyclic"
      case c : Cell => c.toString
    }.getOrElse("outOfRange")
  }
}