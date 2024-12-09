package homework_3

import java.lang

import scala.collection.immutable.HashSet

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
    private def booleanToString(boolean: Boolean): String =
        if (boolean) "правда" else "ложь"

    def prettyBooleanFormatter1(x: Any): String = x match {
        case boolean: Boolean => booleanToString(boolean)
        case other => other.toString
    }

    def prettyBooleanFormatter2(x: Any): String =
        if (x.isInstanceOf[Boolean])
            booleanToString(x.asInstanceOf[Boolean])
        else x.toString

    def prettyBooleanFormatter3(x: Any): String = {
        val booleanClass: Class[lang.Boolean] = classOf[lang.Boolean]
        if (x.getClass == booleanClass)
            booleanToString(booleanClass.cast(x))
        else x.toString
    }


    /**
     * Задание №2
     * Реализуйте функцию нахождения максимального числа в переданной коллекции интов (можно использовать все методы стандартной библиотеки).
     *
     * Реализуйте функцию тремя разными способами, отличающимися тем как функция себя ведет на пустой коллекции.
     * Обратите внимание на возвращаемые типы.
     */
    def max1(xs: Seq[Int]): Int = xs.max

    def max2(xs: Seq[Int]): Seq[Int] =
        if (xs.isEmpty) Seq.empty[Int] else Seq(xs.max)

    def max3(xs: Seq[Int]): Option[Int] = xs match {
        case Nil => None
        case other => Some(other.max)
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
    def sum2(x: Int, y: Int): Int = sumIntegers(HashSet(x, y))
    def sum3(x: Int, y: Int): Int = sumIntegers(new TwoElementsIterable(x, y))

    class TwoElementsIterable(x: Int, y: Int) extends Iterable[Int]{
        override def iterator: Iterator[Int] = new Iterator[Int] {
            private var counter: Int = 0

            override def hasNext: Boolean = counter < 2

            override def next(): Int = counter match {
                case 0 => counter += 1
                    x
                case 1 => counter +=1
                    y
                case _ =>  throw new NoSuchElementException()
            }
        }
    }
}