import scala.annotation.tailrec

object Exercises {
  //просто рекурсия, но используем только операции List, которые работают за O(1)
  def reverse[T](seq: Seq[T]): Seq[T] = {
    @tailrec
    def internalReverse(res: Seq[T], internalSeq: Seq[T]): Seq[T] =
      internalSeq match {
        case head :: tail /*O(1) :happy:*/ => internalReverse(head +: res, tail)
        case _ /*O(1) :happy:*/ => res
      }

    internalReverse(Seq.empty[T], seq)
  }

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */

  //просто рекурсия
  def fibonacci4Index2(idx: Int): Int = {
    @tailrec
    def internalFibonacci4Index(pred1: Int, pred2: Int, currentIdx: Int): Int = {
      if (currentIdx == idx)
        pred2
      else
        internalFibonacci4Index(pred2, pred1 + pred2, currentIdx +1)
    }
    internalFibonacci4Index(0, 1, 1)
  }

  //просто рекурсия
  def fibonacci2(idx: Int): Seq[Int] = {
    @tailrec
    def internalFibonacci(res: Seq[Int], pred1: Int, pred2: Int, currentIdx: Int): Seq[Int] = {
      if (currentIdx == idx)
        (pred2 +: pred1 +: res).reverse //O(n) :sad:
      else internalFibonacci(pred1 +: res, pred2, pred1 + pred2, currentIdx +1)
    }
    internalFibonacci(Seq.empty[Int], 0 , 1, 1)
  }

  //с использованием Stream
  lazy val fib: Stream[Int] = {
    def loop(h: Int, n: Int): Stream[Int] = h #:: loop(n, h + n)
    loop(0, 1)
  }

  def fibonacci4Index(idx: Int): Int = fib(idx)

  def fibonacci(idx: Int): Seq[Int] = fib.take(idx + 1).toList

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = {
    text.flatMap(c => {
      MORSE.getOrElse(c.toUpper.toString, c.toString) + " "
    }).trim
  }

  import scala.collection.breakOut

  def wordReverse(text: String): String = {
    val unicodeWord = """\p{L}+""".r
    unicodeWord.replaceAllIn(text, matched => {
      val stringMatched = matched.matched
      if (stringMatched.head.isUpper)
        stringMatched.reverse.zipWithIndex.map{
          case (char, 0) => char.toUpper
          case (char, idx) if idx == (stringMatched.length-1) => char.toLower
          case (char, _) => char
        }(breakOut)
      else
        stringMatched.reverse
    })
  }
}
