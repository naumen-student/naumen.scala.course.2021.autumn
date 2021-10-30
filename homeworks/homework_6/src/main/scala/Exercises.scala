object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq match {
    case x +: xs => reverse(xs) :+ x
    case _ => seq
  }

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
    case x => reverse((2 to x).foldLeft(Seq(1, 0))((nums, _) => (nums.head + nums.tail.head) +: nums))
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(c => MORSE.getOrElse(c.toUpper.toString, c)).mkString(" ")


  def splitText(text: String): Seq[String] = {
    if (text.isEmpty) return Seq.empty
    if (!text.head.isLetter) return Seq(text.head.toString) ++ splitText(text.substring(1))

    for (i <- 0 until text.length) {
      if (!text(i).isLetter) return Seq(text.substring(0, i)) ++ splitText(text.substring(i))
    }
    Seq(text)
  }

  def wordReverse(text: String): String = splitText(text).map(word => if (word.head.isUpper) {
    word.toLowerCase().reverse.capitalize
  } else {
    word.reverse
  }).mkString

}
