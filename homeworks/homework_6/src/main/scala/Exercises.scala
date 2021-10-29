// А где в заданиях коллекции?
// ▒▒▒▒▒▒▒▒▄▄▄▄▄▄▄▄▒▒▒▒▒▒▒▒
// ▒▒▒▒▒▄█▀▀░░░░░░▀▀█▄▒▒▒▒▒
// ▒▒▒▄█▀▄██▄░░░░░░░░▀█▄▒▒▒
// ▒▒█▀░▀░░▄▀░░░░▄▀▀▀▀░▀█▒▒
// ▒█▀░░░░███░░░░▄█▄░░░░▀█▒
// ▒█░░░░░░▀░░░░░▀█▀░░░░░█▒
// ▒█░░░░░░░░░░░░░░░░░░░░█▒
// ▒█░░██▄░░▀▀▀▀▄▄░░░░░░░█▒
// ▒▀█░█░█░░░▄▄▄▄▄░░░░░░█▀▒
// ▒▒▀█▀░▀▀▀▀░▄▄▄▀░░░░▄█▀▒▒
// ▒▒▒█░░░░░░▀█░░░░░▄█▀▒▒▒▒
// ▒▒▒█▄░░░░░▀█▄▄▄█▀▀▒▒▒▒▒▒
// ▒▒▒▒▀▀▀▀▀▀▀▒▒▒▒▒▒▒▒▒▒▒▒▒

object Exercises {

  def reverse[T](seq: Seq[T]): Seq[T] = {
    seq match {
      case last +: Seq() => Seq(last)
      case x +: rest => reverse(rest) :+ x
    }
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    (0 until idx)
      .foldLeft((0, 1))((prevTwo, _) => (prevTwo._2, prevTwo._1 + prevTwo._2))
      ._1
  }

  def fibonacci(idx: Int): Seq[Int] = {
    (0 until idx)
      .scanLeft((0, 1))((prevTwo, _) => (prevTwo._2, prevTwo._1 + prevTwo._2))
      .map(_._1)
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text
      .map(c => MORSE.getOrElse(c.toUpper.toString, c))
      .mkString(" ")
  }

  def reverseWord(word: String): String = {
    if (word.length <= 2 || word.head.isLower == word.last.isLower) {
      return word.reverse
    }

    val reverseFirstCh = if (word.last.isUpper) word.last.toLower else word.last.toUpper
    val reverseLastCh = if (word.head.isUpper) word.head.toLower else word.head.toUpper

    reverseFirstCh + word.substring(1, word.length - 1).reverse + reverseLastCh
  }

  def wordReverse(text: String): String = {
    // (before is Letter)(after isn't Letter) OR (before isn't Letter)(after is Letter)
    val wordPunctuationBorderReg = """((?<=\P{L})(?=\p{L}))|((?<=\p{L})(?=\P{L}))"""

    text
      .split(wordPunctuationBorderReg)
      .map(wordOrPunct => if (wordOrPunct.head.isLetter) reverseWord(wordOrPunct) else wordOrPunct)
      .mkString("")
  }
}
