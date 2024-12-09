trait Cell
{
  override def toString: String = super.toString
}
class EmptyCell extends Cell {override def toString: String ="empty"}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell {
  override def toString: String = toString(List())

  def toString(list: List[Cell] = List()): String =
    {
      table.getCell(ix, iy).map
      {
        case ref: ReferenceCell =>
          if (list.contains(this))
            return "cyclic"
          else
            ref.toString(list :+ this)
        case _ => return table.getCell(ix, iy).get.toString
      }
    }
      .get
}

class NumberCell(number: Int) extends Cell {override def toString:String = number.toString}

class StringCell(str: String) extends Cell{override def toString:String = str}
