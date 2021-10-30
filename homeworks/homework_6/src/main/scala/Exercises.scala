object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    var newSeq: Seq[T] = Seq()
    seq.foreach(element => newSeq = element +: newSeq)
    newSeq
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = idx match {
    case 1 => 1
    case 2 => 1
    case _ => fibonacci4Index(idx-1) + fibonacci4Index(idx-2)
  }

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 1 => Seq(0, 1)
    case 2 => Seq(0, 1, 1)
    case _ => fibonacci(idx-1):+ fibonacci(idx-1).last + fibonacci(idx-2).last
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String =
    text
      .toArray
      .map(_.toString)
      .map(letter => if (MORSE.contains(letter.toUpperCase)) MORSE(letter.toUpperCase) else letter)
      .mkString(" ")


  def reverseWord(word: String): String = {
    if (word.head.isUpper)
      return (word.tail.reverse :+ word.head.toLower).capitalize
    word.reverse
  }

  def wordReverse(text: String): String = {
    val regex = "([а-яА-Яa-zA-Z]+|[^а-яА-Яa-zA-Z])".r
    regex.findAllIn(text)
      .map(x => reverseWord(x))
      .mkString("")
  }
}
