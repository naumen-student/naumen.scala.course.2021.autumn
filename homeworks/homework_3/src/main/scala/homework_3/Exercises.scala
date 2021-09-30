package homework_3

import scala.collection.{AbstractIterator, mutable}

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
    def prettyBooleanFormatter1(x: Any): String = x match {
        case b: Boolean => if (b) "правда" else "ложь"
        case _ => x.toString
    }

    def prettyBooleanFormatter2(x: Any): String =
        if (x.isInstanceOf[Boolean]) {
            if (x.asInstanceOf[Boolean]) "правда" else "ложь"
        }
        else {
            x.toString
        }

    def prettyBooleanFormatter3(x: Any): String =
        if (x.getClass.getSimpleName == "Boolean") {
            x match { case b: Boolean => if (b) "правда" else "ложь"}
        }
        else {
            x.toString
        }


    /**
     * Задание №2
     * Реализуйте функцию нахождения максимального числа в переданной коллекции интов (можно использовать все методы стандартной библиотеки).
     *
     * Реализуйте функцию тремя разными способами, отличающимися тем как функция себя ведет на пустой коллекции. 
     * Обратите внимание на возвращаемые типы.
     */
    def max1(xs: Seq[Int]): Int = {
        xs match {
            case Seq() => Int.MinValue
            case _ => xs.max
        }
    }

    def max2(xs: Seq[Int]): Seq[Int] = {
        if (xs.isEmpty) Seq() else Seq(xs.max)
    }

    def max3(xs: Seq[Int]): Option[Int] = {
        xs.reduceOption(_.max(_))
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
    case class Couple[T](first: T, second: T) extends Seq[T] {
        override def length: Int = 2

        override def apply(idx: Int): T = {
            if (idx == 0) first
            else if (idx == 1) second
            else throw new IndexOutOfBoundsException(s"Got index ${idx}, expected 0 or 1")
        }

        override def iterator: Iterator[T] = new AbstractIterator[T] { // мы этого на лекции не делали
            private var nextInd = 0

            def hasNext: Boolean = nextInd < 2
            def next: T = {
                nextInd += 1
                if (nextInd == 1) first else second
            }
        }
    }

    def sum1(x: Int, y: Int): Int = sumIntegers(List(x, y))
    def sum2(x: Int, y: Int): Int = sumIntegers(mutable.Stack(x, y))
    def sum3(x: Int, y: Int): Int = sumIntegers(Couple(x, y))
}
