sealed trait Cell

class EmptyCell extends Cell{
   override def toString: String = "empty"
}

class NumberCell(val value:Int) extends Cell{
   override def toString: String = value.toString
}

class StringCell(val value:String) extends Cell{
   override def toString: String = value
}

class ReferenceCell(val x:Int, val y:Int, val table: Table) extends Cell {
  override def toString: String =
    if (isCyclic(this)) "cyclic"
    else s"${getReference.toString}"

  private def getReference = table.getCell(x, y).get

  private def isCyclic(cell: Cell): Boolean = {
    def iter(i1: ReferenceCell, i2: ReferenceCell): Boolean = {
      i1.getReference match {
        case nexti1: ReferenceCell =>
          i2.getReference match {
            case nexti2: ReferenceCell =>
              nexti2.getReference match {
                case nextnexti2: ReferenceCell =>
                  if (nexti1 eq nextnexti2) true
                  else iter(nexti1, nextnexti2)
                case _ => false
              }
            case _ => false
          }
        case _ => false
      }
    }
    cell match {
      case v: ReferenceCell => iter(v, v)
      case _ => false
    }
  }
}