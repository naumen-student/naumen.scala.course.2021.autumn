
trait Cell{

}

class EmptyCell extends Cell{
  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {
  override def toString: String = number.toString()
}

class StringCell (str : String) extends Cell{
  override def toString: String = str;
}

class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell  {
  override def toString: String = {
    table.getCell(ix, iy) match {

      case None => "outOfRange"
      case Some(someCell) => someCell.getClass.getName match {
        case "ReferenceCell" => if (table.getCell(this.ix, this.iy) == this) "cyclic" else someCell.toString
        case _ => someCell.toString
     }
    }
  }
}