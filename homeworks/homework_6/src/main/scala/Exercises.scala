import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    idx match {
      case 0 => 0
      case 1 => 1
      case _ => fibonacci4Index(idx - 2) + fibonacci4Index(idx - 1)
    }
  }

  def fibonacci(idx: Int): Seq[Int] = {
    idx match {
      case 0 => Seq(0)
      case 1 => Seq(0, 1)
      case _ =>
        val fib_seq = fibonacci(idx - 1)
        fib_seq :+ fib_seq.takeRight(2).sum
    }
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text
    .map(symbol => MORSE.getOrElse(symbol.toUpper.toString, symbol.toString))
    .mkString(" ")


  val r: Regex = "(\\w|[ЁёА-я])+|.".r
  def wordReverse(text: String): String = r.findAllIn(text)
    .map(word => {
      if (word.charAt(0).isUpper)
        word.toLowerCase.reverse.capitalize
      else word.toLowerCase.reverse})
    .mkString("")
}
