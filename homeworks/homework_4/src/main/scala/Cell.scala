trait Cell

object CellState
extends Enumeration {
  val EMPTY = "empty"
  val OUT_OF_RANGE = "outOfRange"
  val CYCLIC = "cyclic"
}

class EmptyCell
extends Cell {
  override def toString: String = {
    CellState.EMPTY
  }
}

class NumberCell(value: Int)
extends Cell {
  override def toString: String = {
    s"$value"
  }
}

class StringCell(value: String)
extends Cell {
  override def toString: String = {
    s"$value"
  }
}

class ReferenceCell(x: Int, y: Int, table: Table)
extends Cell {
  override def toString: String = {
    tryGetNextCell match {
      case None => {
        CellState.OUT_OF_RANGE
      }

      case Some(cell: ReferenceCell) => {
        if (cell.tryGetNextCell
                .contains(this)) {
          CellState.CYCLIC
        } else s"$cell"
      }

      case Some(cell: Cell) => {
        s"$cell"
      }
    }
  }

  protected def tryGetNextCell: Option[Cell] = {
    table.getCell(x, y)
  }
}