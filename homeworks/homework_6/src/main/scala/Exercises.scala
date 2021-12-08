import scala.util.matching.Regex

object Exercises {
  def reverse[T](seq: Seq[T]): Seq[T] = seq.foldRight(Seq.empty[T])((element, reversedElements) => reversedElements :+ element)

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = fibonacci(idx).last

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case x if x < 0 => Seq(-1)
    case 0 => Seq(0)
    case 1 => Seq(0, 1)
    case x => (2 to x).foldLeft(Seq(0, 1))((seq, _) => seq :+ (seq.last + seq.init.last))
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.map(char => MORSE.getOrElse(char.toString.toUpperCase(), char)).mkString(" ")

  val wordRegExp: Regex = "([а-яА-Яa-zA-Z]+|[^а-яА-Яa-zA-Z])".r

  def wordReverse(text: String): String = wordRegExp.findAllIn(text).map {
    case word if word.head.isUpper => (word.head.toLower + word.tail).reverse.capitalize
    case word => word.reverse
  }.mkString("")
}
