trait Cell {
  def returnValue: Any
}

class EmptyCell extends Cell {

  override def returnValue: Any = None

  override def toString: String = "empty"
}

class NumberCell(number: Int) extends Cell {

  override def returnValue: Any = number

  override def toString: String = number.toString

}

class StringCell(string: String) extends Cell {

  override def returnValue: Any = string

  override def toString: String = string
}

class ReferenceCell(val ix: Int, val iy: Int, table: Table) extends Cell {

  override def returnValue: Any = {
    table.getCell(ix, iy)
  }

  override def toString: String = {
    val tgt = table.getCell(ix, iy)

    if (ix >= table.height || ix < 0 || iy >= table.width || iy < 0)
      return "outOfRange"

    if (tgt.isDefined) {
      val targetVal = tgt.get

      if (!targetVal.isInstanceOf[ReferenceCell]) {
        targetVal.toString
      } else {
        if (targetVal.asInstanceOf[ReferenceCell].ix == ix && targetVal.asInstanceOf[ReferenceCell].ix == ix) {
          "cyclic"
        } else {
          targetVal.toString
        }
      }
    } else {
      "empty"
    }
  }
}