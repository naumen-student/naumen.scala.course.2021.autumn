
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
      case _ => fibonacci4Index(idx - 1) + fibonacci4Index(idx - 2)
    }
  }

  def fibonacci(idx: Int): Seq[Int] = {
    var resultSeq = scala.collection.mutable.ListBuffer[Int](0, 1)
    idx match {
      case 0 => Seq(0)
      case 1 => Seq(1)
      case _ =>
        for (i <- 2 to idx) {
          val temp = resultSeq(i - 1) + resultSeq(i - 2)
          resultSeq += temp
        }
        resultSeq.result()
    }
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    val notEncodingStrings = Seq("!")
    text.map(c => {
      val stringChar = c.toString
      if (notEncodingStrings contains stringChar) {
        s"${stringChar}"
      } else {
        val tmp = MORSE.getOrElse(stringChar.toUpperCase, stringChar)
        s" $tmp"
      }
    }).mkString("").trim
  }


  def wordReverse(text: String): String = {
    var result = scala.collection.mutable.ListBuffer[String]()
    var word = scala.collection.mutable.ListBuffer[Char]()
    for (c <- text) {
      if (c.isLetter) {
        word += c
      } else {
        if (word.length > 0 && word.head.isUpper){
            val tmp = (word.head.toString.toLowerCase + word.drop(1).take(word.length - 2).mkString("") + word.last.toString.toUpperCase).reverse
            result += tmp
        } else {
          val tmp = word.mkString("").reverse
          result += tmp
        }
        result += c.toString
        word = scala.collection.mutable.ListBuffer[Char]()
      }
    }
    result.mkString("")
  }

}
