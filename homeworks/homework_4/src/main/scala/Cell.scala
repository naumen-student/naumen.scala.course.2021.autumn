
class Cell(private val value: Any) {
  override def toString: String = value.toString
}
class EmptyCell extends Cell("empty")

class NumberCell(private val value: Int) extends Cell(value)

class StringCell(private val value: String) extends Cell(value)

case class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = {
    table.getCell(ix, iy) match {
      case Some(r: ReferenceCell) =>
        if (r.table.getCell(r.ix, r.iy) == Option(this)) "cyclic"
        else r.toString
      case Some(x) => x.toString
      case None => "outOfRange"
    }
  }
}
