import scala.collection.mutable.ListBuffer

object Exercises {

  def reverse[T](seq: Seq[T]): Seq[T] = {
    val result: Seq[T] = Seq()
    @tailrec
    def reversedSeq[A](result: Seq[A], seq: Seq[A]): Seq[A] = {
      seq match {
        case Seq() => result
        case _ => reversedSeq(seq.tail, seq.head +: result)
      }
    }
    reversedSeq(Seq, res)
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
    def getMorseSymb(symbol: String):String = {
      val upperText = text.toUpperCase()
      if (MORSE.contains(upper))
        MORSE(upper)
      else symbol
    }
    text.map(s => getMorseSymb(s.toString)).mkString(" ")
  }

  def wordReverse(text: String): String = {
    def getCapitals(text : String): Seq[Int] = {
      for {i <- 0 until text.length if text(i).isUpper } yield i
    }
    val punctuation = text.split("[a-zA-ZА-Яа-я]+").reverse.init.reverse
    val words = text.split("[ !.?,]").filter(p => p != "")
    words.map({
      case word if word.head.isUpper => word.toLowerCase.reverse.capitalize
      case word => word.reverse
    }).zip(punctuation).map({case(str, s) => s"$str$s"}).mkString("")
  }
}