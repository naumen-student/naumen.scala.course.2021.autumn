import scala.util.matching.Regex

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    var newSeq: Seq[T] = Seq()
    seq.foreach(p => newSeq = p +: newSeq)
    newSeq
  }

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
    var f: Seq[Int] = Seq()
    (0 to idx).foreach(i => f = f :+ fibonacci4Index(i))
    f
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text
    .map(l => MORSE.getOrElse(l.toUpper.toString, l))
    .mkString(" ")

  def wordReverse(text: String): String = {
    val wordRegexp: Regex = "([а-яА-Яa-zA-Z]+|[^а-яА-Яa-zA-Z])".r
    wordRegexp.findAllIn(text)
      .map(word => if (word.head.isUpper) word.toLowerCase.reverse.capitalize else word.reverse)
      .mkString
  }

}
