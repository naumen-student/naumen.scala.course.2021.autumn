import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

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
    val fibonacciList = ListBuffer[Int]()
    for (i <- 0 to idx) fibonacciList += fibonacci4Index(i)
    fibonacciList
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text.map(c => MORSE.getOrElse(c.toUpper.toString, c)).mkString(" ")
  }


  def wordReverse(text: String): String = {
    var words = text.split(" ")
    words = words.map(w => processWord(w))

    def processWord(word: String): String = {
      val wordParts = word.span(_.isLetter)
      var letterWord = wordParts._1.reverse.mkString("")
      if (wordParts._1.head.isUpper) {
        letterWord = wordParts._1.reverse.mkString("").toLowerCase().capitalize
      }
      letterWord + wordParts._2
    }
    words.mkString(" ")
  }

}
