object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = {
    val result = collection.mutable.MutableList[T]()
    for (i <- Range(seq.length - 1, -1, -1)) {
      result += seq(i)
    }
    result
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    fibonacci(idx).last
  }

  def fibonacci(idx: Int): Seq[Int] = {
    val result = collection.mutable.MutableList[Int](0, 1)
    for (i <- Range(2, idx + 1)) {
      result += result(i - 2) + result(i - 1)
    }
    result
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
    "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
    "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
    "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
    "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    val processedText = text.toUpperCase
    val result = collection.mutable.MutableList[String]()
    for (symbol <- processedText) {
      if(symbol.isLetter) {
        result += MORSE(symbol.toString)
      } else {
        result += symbol.toString
      }
    }
    result.mkString(" ")
  }


  def wordReverse(text: String): String = {
    var start = 0
    var end = 0
    var result = ""
    for (symbol <- text) {
      if (symbol.isLetter) {
        end += 1
      } else {
        val word = text.substring(start, end)
        val reversed = word.reverse
        if (word.nonEmpty && word.head.isUpper) {
          result += reversed.toLowerCase().capitalize
        } else {
          result += reversed
        }
        result += symbol.toString
        end += 1
        start = end
      }
    }
    result
  }
}