object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  val fib: Stream[Int] = 0 #:: 1 #:: fib.zip(fib.tail).map(p => p._1 + p._2)

  def fibonacci4Index(idx: Int): Int = fib(idx)

  def fibonacci(idx: Int): Seq[Int] = idx match {
    case 0 => Seq(0)
    case 1 => Seq(0, 1)
    case i => (2 to i).foldLeft(Seq(0, 1))((seq, _) => seq :+ (seq.init.last + seq.last))
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
    val splited = text.split("[ .,!?]+")
    println(splited.mkString("|"))
    val punct = text.split("[a-zA-ZА-Яа-я]+").reverse.init.reverse
    println(punct.mkString("|"))
    splited.map {
      case x if x.head.isUpper => x.toLowerCase.reverse.capitalize
      case x => x.reverse
    }.zip(punct).map{case (str, s) => s"$str$s"}.mkString("")
  }

}
