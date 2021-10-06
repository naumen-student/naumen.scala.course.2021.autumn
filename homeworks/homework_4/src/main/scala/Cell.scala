trait Cell {
  def toString(): String
}

class EmptyCell extends Cell{
  override def toString: String = "empty"
}