import scala.collection.immutable.List

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    var reversed: List[T] = List()
    for (x <- seq)
      reversed = x :: reversed
    reversed
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
      case _ => fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
    }
  }

  var accumulator: List[Int] = List()

  def fibonacci(idx: Int): Seq[Int] = {
    def fibHelper(idx: Int) = {
      idx match {
        case 0 => {
          accumulator = accumulator :+ 0
          accumulator
        }
        case 1 => {
          accumulator = accumulator :+ 1
          accumulator
        }
        case _ => {
          val f1 = fibonacci4Index(idx - 1)
          val f2 = fibonacci4Index(idx - 2)
          accumulator = accumulator :+ f1
          accumulator = accumulator :+ f2
          accumulator = accumulator :+ (f1 + f2)
          accumulator
        }
      }
    }

    fibHelper(idx).sorted
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    val textChars = text.toUpperCase.split("")
    val keys = MORSE.keys.toList

    textChars.flatMap(x => {
      if (keys.contains(x))
        MORSE.get(x)
      else
        x
    }).mkString(" ")
      .replace(" !", "!")
  }


  def wordReverse(text: String): String = {
    val words = text.split("[-.?!)(,: ]").filter(_.nonEmpty).toList
    val symbols = text.split("[a-zа-яA-ZА-Я]").filter(_.nonEmpty).toList

    (words.map(word => specialReverse(word)) zip symbols).map(x => x._1 + x._2).mkString("")
  }

  def specialReverse(word: String): String = {
    val originWord = word
    val reversedWord = word.reverse.toLowerCase

    var result = ""

    for ((originLtr, ltr) <- originWord zip reversedWord) {
      if (originLtr.isUpper)
        result += ltr.toUpper
      else
        result += ltr.toLower
    }

    result
  }
}
