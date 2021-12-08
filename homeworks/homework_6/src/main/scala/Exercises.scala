object Exercises {

  def reverse[T](seq: Seq[T]): Seq[T] = {
    seq.foldLeft(Seq[T]()) {(res, el) =>  el +: res}
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = idx match  {
    case 1 => 1
    case 0 => 0
    case _ => fibonacci4Index(idx-1) + fibonacci4Index(idx-2)
  }

  def fibonacci(idx: Int): Seq[Int] = {
    Seq.range(0, idx+1).map{fibonacci4Index}
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
      text.toSeq.map {el => MORSE.get(el.toString.toUpperCase()) match {
      case None if el.isWhitespace => " " + el
      case Some(value) => " " + value
      case _ => el} }.mkString.trim
  }

  def wordReverse(text: String): String = {
    val wordsRev = text.reverse.trim.split("[.,!? ]+").filter(_.nonEmpty).map {
      str => if (str.last.isUpper) {str.charAt(0).toUpper + str.slice(1, str.length).toLowerCase}
      else str}.reverse
    val delimiters = text.split("[А-ЯЁа-яёA-Za-z]").filter{_.nonEmpty}
    wordsRev.zip(delimiters).map{ tp => tp._1 ++ tp._2}.mkString
  }

}
