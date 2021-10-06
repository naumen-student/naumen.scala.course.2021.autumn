trait Cell {
  def toString(): String
}

class EmptyCell extends Cell{
  override def toString: String = "empty"
}

class NumberCell(val value: Int) extends Cell{
  override def toString: String = value.toString
}