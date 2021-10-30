object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.foldRight(Seq[T]())((elem, seq) => seq :+ elem)

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = idx match {
    case n if n < 2 => n
    case n if n > 1 => fibonacci4Index(n-1) + fibonacci4Index(n-2)
  }

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 0 => Seq(0)
    case 1 => Seq(0, 1)
    case n if n > 1 => fibonacci(n-1) :+ fibonacci(n-1).last + fibonacci(n-2).last
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(ch => MORSE.getOrElse(ch.toUpper.toString, ch.toString)).mkString(" ")

  def wordReverse(text: String): String = {
    def reverseWordOnly(s: String): String = {
      val (word, delimiters) = s.span(x => x.isLetter)
      (if (word(0).isUpper) word.reverse.toLowerCase.capitalize else word.reverse).concat(delimiters)
    }
    text.split(' ').map(reverseWordOnly).mkString(" ")
  }

}
