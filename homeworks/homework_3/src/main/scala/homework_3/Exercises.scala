package homework_3

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
    def prettyBooleanFormatter1: Any => String = {
        case boolean: Boolean => prettyBooleanFormatter(boolean)
        case other: Any => other.toString
    }

    def prettyBooleanFormatter2(x: Any): String = {
        if (x.isInstanceOf[Boolean]) {
            prettyBooleanFormatter(x.asInstanceOf[Boolean])
        } else {
            x.toString
        }
    }

    def prettyBooleanFormatter3(x: Any): String = {
        if (x.getClass == classOf[java.lang.Boolean] || x.getClass == classOf[Boolean]) {
            prettyBooleanFormatter(x.asInstanceOf[Boolean])
        } else {
            x.toString
        }
    }

    private def prettyBooleanFormatter: Boolean => String = if (_) "правда" else "ложь"


    /**
     * Задание №2
     * Реализуйте функцию нахождения максимального числа в переданной коллекции интов (можно использовать все методы стандартной библиотеки).
     *
     * Реализуйте функцию тремя разными способами, отличающимися тем как функция себя ведет на пустой коллекции. 
     * Обратите внимание на возвращаемые типы.
     */
    def max1(xs: Seq[Int]): Int = xs.max

    def max2(xs: Seq[Int]): Seq[Int] = xs.sorted.lastOption.toSeq

    def max3(xs: Seq[Int]): Option[Int] = xs.sorted.lastOption

    /**
     * Задание №3
     * Допустим дана функция sumIntegers, которая умеет суммировать числа.
     */
    def sumIntegers[CollectionType <: Iterable[Int]](xs: CollectionType): Int = xs.sum

    /**
     * Реализуйте на основе нее 3 варианта суммирования 2х чисел, отличающиеся способом передачи этих 2х чисел в функцию sumIntegers.
     * Как минимум одна из реализаций должна использовать тип данных (класс) написанный вами самостоятельно.
     */ 
    def sum1(x: Int, y: Int): Int = sumIntegers(x :: y :: Nil)
    def sum2(x: Int, y: Int): Int = sumIntegers(IntIterable(x, y))
    def sum3(x: Int, y: Int): Int = sumIntegers(Seq(x, y))

    case class IntIterable(el: Int*) extends Iterable[Int] {
        override def iterator: Iterator[Int] = el.iterator
    }
}
