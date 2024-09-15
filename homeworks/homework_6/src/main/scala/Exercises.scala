import scala.annotation.tailrec

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    @tailrec
    def recReverse(list1: List[T], list2: List[T]): List[T] = list1 match {
      case Nil => list2
      case head :: tl => recReverse(tl, head :: list2)
    }

    recReverse(seq.toList, Nil)
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    if (idx == 0) 0 else if (idx == 1 || idx == 2) 1 else fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
  }

  def fibonacci(idx: Int): Seq[Int] = {
    @tailrec
    def fib(id: Int, acc: List[Int]): List[Int] = {
      if (id == idx + 1)
        acc.reverse
      else if (id == 0)
        fib(id + 1, 0 :: acc)
      else if (id == 1)
        fib(id + 1, 1 :: acc)
      else {
        acc match {
          case a :: b :: _ => fib(id + 1, (a + b) :: acc)
        }
      }
    }
    fib(0, Nil)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    if (text.isEmpty)
      ""
    else {
      val head = MORSE.getOrElse(text.head.toUpper.toString, text.head.toString)
      (head +: text.drop(1).map { c =>
        MORSE
          .get(c.toUpper.toString)
          .map(" " + _)
          .getOrElse(
            if (c == ' ') "  " else c.toString
          )
      }).mkString
    }
  }


  def wordReverse(text: String): String = {
    @tailrec
    def word(idx: Int, stack: List[Char], isUpper: Boolean, builder: StringBuilder): String = {
      if (idx == text.length)
        builder.mkString
      else {
        text(idx) match {
          case c if c.isLetter && stack.isEmpty => word(idx + 1, c.toLower :: stack, c.isUpper, builder)
          case c if c.isLetter => word(idx + 1, c.toLower :: stack, isUpper, builder)
          case c if stack.isEmpty => word(idx + 1, stack, isUpper, builder += c)
          case c =>
            builder ++= (if (isUpper) stack.head.toUpper else stack.head) :: stack.tail
            word(idx + 1, Nil, isUpper, builder += c)
        }
      }
    }
    word(0, Nil, false, new StringBuilder)
  }
}
