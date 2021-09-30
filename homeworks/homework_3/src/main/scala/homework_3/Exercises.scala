package homework_3

import homework_3.Exercises.{max1, max2, max3, prettyBooleanFormatter1, prettyBooleanFormatter2, prettyBooleanFormatter3, sum1, sum2, sum3}

import scala.collection.AbstractIterator

object Exercises {

  /**
   * Задание №1
   * Реализуйте функцию, которая принимает любой тип и преобразует его в строку.
   * Для всех типов кроме Boolean достаточно воспользоваться стандартной функцией .toString.
   * Для типа Boolean сделайте особое преобразование: true -> "правда", false -> "ложь".
   *
   * Реализуйте функцию тремя разными способами, отличающимися тем, как определяется какой тип имеет значение переданное в аргументе.
   * Определение типа необходимо для реализации специальной логики работы с Boolean значениями, которая описана в условии выше.
   */
  def prettyBooleanFormatter1(x: Any): String = {
    if (x.isInstanceOf[Boolean]) {
      if (x.asInstanceOf[Boolean]) "правда" else "ложь"
    } else {
      x.toString
    }
  }

  def prettyBooleanFormatter2(x: Any): String = {
    x match {
      case bool: Boolean => if (bool) "правда" else "ложь"
      case _ => x.toString
    }
  }

  def prettyBooleanFormatter3(x: Any): String = {
    x.getClass.getName match {
      case "java.lang.Boolean" => if (x.asInstanceOf[Boolean]) "правда" else "ложь"
      case _ => x.toString
    }
  }


  /**
   * Задание №2
   * Реализуйте функцию нахождения максимального числа в переданной коллекции интов (можно использовать все методы стандартной библиотеки).
   *
   * Реализуйте функцию тремя разными способами, отличающимися тем как функция себя ведет на пустой коллекции.
   * Обратите внимание на возвращаемые типы.
   */
  def max1(xs: Seq[Int]): Int = {
    if (xs.isEmpty) 0 else xs.max
  }

  def max2(xs: Seq[Int]): Seq[Int] = {
    if (xs.isEmpty) Seq() else Seq(xs.max)
  }

  def max3(xs: Seq[Int]): Option[Int] = {
    val result: Option[Int] = if (xs.nonEmpty) Some(xs.max) else None

    result
  }

  /**
   * Задание №3
   * Допустим дана функция sumIntegers, которая умеет суммировать числа.
   */
  def sumIntegers[CollectionType <: Iterable[Int]](xs: CollectionType): Int = xs.sum

  /**
   * Реализуйте на основе нее 3 варианта суммирования 2х чисел, отличающиеся способом передачи этих 2х чисел в функцию sumIntegers.
   * Как минимум одна из реализаций должна использовать тип данных (класс) написанный вами самостоятельно.
   */
  def sum1(x: Int, y: Int): Int = sumIntegers(List(x, y))

  def sum2(x: Int, y: Int): Int = sumIntegers(Vector(x, y))

  def sum3(x: Int, y: Int): Int = sumIntegers(TwoSummables(x, y))

  object TwoSummables{
    def apply(x: Int, y: Int): Iterable[Int] = new TwoSummables(x, y)

  }

  class TwoSummables(x: Int, y: Int) extends Iterable[Int] {

    var counter = 0

    val iterator_ = new AbstractIterator[Int] {
      override def hasNext: Boolean = counter != 2

      override def next(): Int = if (counter == 0) {
        counter += 1; x
      } else {
        counter += 1; y
      }
    }

    override def iterator: Iterator[Int] = iterator_
  }
}

