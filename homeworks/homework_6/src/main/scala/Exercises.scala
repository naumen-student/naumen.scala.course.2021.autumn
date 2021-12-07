

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int =
    {
      val sqrt = math.sqrt(5)
      (math.pow(((sqrt + 1) / 2),idx) / sqrt + 0.5).toInt
    }

  def fibonacci(idx: Int): Seq[Int] =
    {
      var fibList = List[Int]()
      fibList = fibList :+ 0
      fibList = fibList :+ 1
      for (i <- 2 to idx)
        fibList = fibList:+ (fibList(i-1)+fibList(i-2))
      fibList
    }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String =
    {
      val res = new StringBuilder()
      for (letter <- text) {
        val upLetter = letter.toString.toUpperCase()
        if (MORSE.contains(upLetter)) {
          res.append(MORSE(upLetter))
          res.append(' ')
        }
        else if (letter == ' ')
          res.append("  ")
        else {
          if (res.nonEmpty)
            res.deleteCharAt(res.length-1)
          res.append(letter)
        }
      }
      if (res.last == ' ')
        return res.toString().dropRight(1)
      res.toString()
    }


  def wordReverse(text: String): String =
    {
      val words = text.split(" ")
      val resultWords = new StringBuilder()
      for (word <- words) {
        var resultWord = ""
        var changeWord = ""
        for (letter <- word)
          if (letter.isLetter)
            changeWord = changeWord:+letter
        for (i <- 0 until word.length){
          if (word(i).isLetter) {
            val update = if (word(i).toUpper == word(i)) changeWord(changeWord.length-1).toUpper
              else changeWord(changeWord.length - i -1).toLower
            resultWord = resultWord :+ update
          }
          else
            resultWord = resultWord:+word(i)
        }
        resultWords.append(resultWord).append(" ")
      }
      resultWords.toString().dropRight(1)
    }
}
