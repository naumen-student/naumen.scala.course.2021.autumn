import scala.annotation.tailrec
import scala.language.postfixOps
import scala.collection.mutable.ArrayBuffer

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    val res: Seq[T] = Seq()
    @tailrec
    def reversedSeq[A](_seq: Seq[A], _res: Seq[A]): Seq[A] = {
      _seq match {
        case Seq() => _res
        case _ => reversedSeq(_seq.tail, _seq.head +: _res)
      }
    }
    reversedSeq(seq, res)
  }


  def fibonacci4Index(idx: Int): Int = idx match {
    case 0 => idx
    case 1 => idx
    case _ => fibonacci4Index(idx - 2) + fibonacci4Index(idx - 1)
  }

  def fibonacci(idx: Int): Seq[Int] = (0 to idx).map(idx => fibonacci4Index(idx))

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    val lastChars: List[Char] = List('.', '!', '?')
    if (lastChars.contains(text.last)) {
      text.init.map(ch => ch.toUpper).map(ch => MORSE.getOrElse(ch.toString, ch)).mkString(" ") + text.last
    } else {
      text.map(ch => ch.toUpper).map(ch => MORSE.getOrElse(ch.toString, ch)).mkString(" ")
    }
  }


  def wordReverse(text: String): String = {
    val words = text.split("[.,!? ]+")
    val punctuation = text.split("[а-яА-Я]+").tail
    val propReverse = ArrayBuffer[String]()
    for (w <- words) {
      if (w.head.isUpper){
        val reversedWord = w.reverse.toLowerCase
        val word = reversedWord.head.toString.toUpperCase + reversedWord.tail
        propReverse += word
      } else {
        propReverse += w.reverse
      }
    }
    propReverse.zip(punctuation).map{case(word, punctuation) => s"$word$punctuation"}.mkString("")
  }
}
