trait Cell{
  def toString: String
}

class EmptyCell() extends Cell{
  override def toString: String = "empty"
}

class StringCell(var string: String = "") extends  Cell{
  override def toString: String = string
}

class NumberCell(var number: Int) extends  Cell{
  override def toString: String = number.toString
}

class ReferenceCell(val ix: Int, val iy: Int, val table: Table) extends  Cell{
  override def toString: String = {
    if (ix > table.len || ix < 0 || iy > table.len || iy < 0) "outOfRange"
    else findValueByReference(this, Seq[ReferenceCell]())
  }


  private def findValueByReference (current: ReferenceCell, visited: Seq[ReferenceCell]): String = {
    table.getCell(current.ix, current.iy) match {
      case Some(cell) => cell match {
        case next: ReferenceCell => {
          if (visited.contains(next)) "cyclic"
          else findValueByReference(next, visited :+ next)
        }
        case _ => cell.toString
      }
    }
  }
}