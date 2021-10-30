import scala.annotation.tailrec

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {

    @tailrec
    def loop(seq: Seq[T], reversed_seq: Seq[T]): Seq[T] = seq match {
      case x::tail => loop(tail, x +: reversed_seq)
      case Nil => reversed_seq
    }

    loop(seq, Seq[T]())
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {

    @tailrec
    def loop(a: Int, b: Int, acc: Int): Int = acc match {
      case 0 => b
      case _ => loop(b, a + b, acc - 1)
    }

    idx match {
      case 0 => 0
      case 1 => 1
      case _ => loop(0, 1, idx - 1)
    }
  }


  def fibonacci(idx: Int): Seq[Int] = {

    @tailrec
    def loop(seq: Seq[Int], a: Int, b: Int, acc: Int): Seq[Int] = acc match {
      case 0 => seq
      case _ => loop(seq :+ (a + b), b, a + b, acc - 1)
    }

    idx match {
      case 0 => Seq(0)
      case 1 => Seq(0, 1)
      case _ => loop(Seq(0, 1), 0, 1, idx - 1)
    }
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.toList.map({
      case x if MORSE.contains(x.toUpper.toString) => MORSE(x.toUpper.toString)
      case x => x.toString
    }).mkString(" ")


  def wordReverse(text: String): String = {
    val symbolPattern = "([a-zA-Zа-яА-Я])"

    @tailrec
    def accumWord(list: List[Char], reversed: List[Char], accum: List[Char]): List[Char] = list match {
      case x::tail if x.toString.matches(symbolPattern) => accumWord(tail, reversed, accum :+ x)
      case x::tail => accumNoWord(tail, reversed ++ reverseWord(accum), List[Char](x))
      case Nil => reversed ++ reverseWord(accum)
    }

    def reverseWord(list: List[Char]): List[Char] = {
      @tailrec
      def changeCase(listToChange: List[Char], listChanger: List[Char], accum: List[Char]): List[Char] = listToChange match {
        case x :: tail if listChanger.head.isUpper => changeCase(tail, listChanger.tail, accum :+ x.toUpper)
        case x :: tail => changeCase(tail, listChanger.tail, accum :+ x.toLower)
        case Nil => accum
      }

      val reversed = reverse(list)
      changeCase(reversed.toList, list, List[Char]())
    }

    @tailrec
    def accumNoWord(list: List[Char], reversed: List[Char], accum: List[Char]): List[Char] = list match {
      case x :: tail if x.toString.matches(symbolPattern) => accumWord(tail, reversed ++ accum, List[Char](x))
      case x :: tail => accumNoWord(tail, reversed, accum :+ x)
      case Nil => reversed ++ accum
    }

    accumWord(text.toList, List[Char](), List[Char]()).mkString
  }
}
