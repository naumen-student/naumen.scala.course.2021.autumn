object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.foldRight(Seq.empty[T])((e,s) => s :+ e)

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = fibonacci(idx).last

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 0 => Seq(0)
    case 1 => Seq(0, 1)
    case i => (2 to i).foldLeft(Seq(0, 1))((s, _) => s :+ (s.init.last + s.last))
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.last match {
    case '.'|'!'|'?' => text.init.map(l => MORSE.getOrElse(l.toString.toUpperCase, l)).mkString(" ") + text.last
    case _ => text.map(l => MORSE.getOrElse(l.toString.toUpperCase, l)).mkString(" ")
  }

  def wordReverse(text: String): String = {
    val words = text.split("[ .,!?]+")
    val marks = text.split("[a-zA-ZА-Яа-я]+").reverse.init.reverse
    words.map {
      case x if x.head.isUpper => x.toLowerCase.reverse.capitalize
      case x => x.reverse
    }.zip(marks).map{case (word, mark) => s"$word$mark"}.mkString("")
  }

}
