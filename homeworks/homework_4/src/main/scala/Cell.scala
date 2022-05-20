import scala.annotation.tailrec

trait Cell{
  def toString: String
}

case class EmptyCell() extends Cell{
  override def toString: String = "empty"
}

case class NumberCell(val number: Int) extends Cell{
  override def toString: String = f"$number"
}

case class StringCell(val string: String) extends Cell{
  override def toString: String = string
}

case class ReferenceCell(val ix: Int, val iy: Int, val table: Table) extends Cell{
  override def toString: String = {
    if (table.inBound(ix, iy)){
      if (lookOnCyclic()) "cyclic"
      else getNextCell.toString
    }
    else "outOfRange"
  }

  def getNextCell: Cell = table.getCell(ix, iy).get

  private def lookOnCyclic(): Boolean = {
    def isRefCell(cell: Cell): Boolean = {
      cell match {
        case ReferenceCell(ix, iy, table) => true
        case _ => false
      }
    }
    @tailrec
    def followTheLink(tortoise: ReferenceCell, hare: ReferenceCell): Boolean = {
      if(tortoise == hare) true
      else{
        val hareFirstStep = hare.getNextCell
        if(isRefCell(hareFirstStep)){
          val hareSecondStep = hareFirstStep.asInstanceOf[ReferenceCell].getNextCell
          if(isRefCell(hareSecondStep)){
            followTheLink(tortoise.getNextCell.asInstanceOf[ReferenceCell], hareSecondStep.asInstanceOf[ReferenceCell])
          }
          else false
        }
        else false
      }
    }
    val tortoise = getNextCell
    if(isRefCell(tortoise)){
      val hare = tortoise.asInstanceOf[ReferenceCell].getNextCell
      if(isRefCell(hare)){
        followTheLink(tortoise.asInstanceOf[ReferenceCell], hare.asInstanceOf[ReferenceCell])
      }
      else false
    }
    else false
  }
}