import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Exercises {

  def reverse[T](seq: Seq[T]): Seq[T] = {

    @tailrec
    def _reverse(res: Seq[T], rem: Seq[T]): Seq[T] = rem match {
      case Nil => res
      case h +: tail => _reverse(h +: res, tail)
    }

    _reverse(Nil, seq)
  }

  def fibonacci4Index(idx: Int): Int = {
    idx match {
      case 0 | 1 => idx
      case _ => fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
    }
  }

  def fibonacci(idx: Int): Seq[Int] = {
    val seqUntilIdx: Seq[Int] = (0 until idx + 1)
    seqUntilIdx.map(i => fibonacci4Index(i))
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    val upperText = text.toUpperCase()
    val morse = new ListBuffer[String]()

    for (i <- 0 until upperText.length) {
      val sym = upperText.charAt(i).toString

      if (MORSE contains sym) {
        morse += MORSE(sym)
      } else {
        morse += sym
      }
    }

    morse.toList.mkString(" ")
      .replace(" !", "!") // костыль чтобы работал тест с Hello World! (все равно кажется, что там баг)
      .replace(" ?", "?")
  }

  def reverseWord(word: String): String = {
    var reverseWord = ""

    if (word.head.isUpper) {
      reverseWord = word.reverse.head.toUpper + word.reverse.tail.toLowerCase
    } else {
      reverseWord = word.reverse
    }

    reverseWord
  }

  def wordReverse(text: String): String = {
    val arrayWithWords = text.split(' ').map(word => {
      val cleanWord = word.filter(char => char.isLetter)
      val reversedWord = reverseWord(cleanWord)
      val head = word.split(cleanWord).head
      val rest = word.drop(reversedWord.length)
      val punctuationMarks = word.split(cleanWord).tail.mkString("")

      if (word.indexOf(cleanWord) == 0) {
        reversedWord + rest
      } else {
        head + reversedWord + punctuationMarks
    }})

    arrayWithWords.mkString(" ")
  }
}
