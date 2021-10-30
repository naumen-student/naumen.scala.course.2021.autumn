object Exercises {
  val cyrillicWordsDetectorSplitter = "[а-яА-ЯёЁ]+|[^а-яА-ЯёЁ]+".r
  val cyrillicWordsDetector = "[а-яА-ЯёЁ]+".r

  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = idx match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
  }

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 0 => Seq(0)
    case _ => fibonacci(idx - 1) :+ fibonacci4Index(idx)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = MORSE.foldLeft(text.split("").mkString(" "))((a, b) => a.toUpperCase.replace(b._1, b._2))


  def wordReverse(text: String): String = cyrillicWordsDetectorSplitter
    .findAllIn(text)
    .map(word => if (cyrillicWordsDetector.pattern.matcher(word).matches) word.reverse else word)
    .map(word => if (word.last.isUpper) word.toLowerCase.capitalize else word)
    .mkString("")

}
