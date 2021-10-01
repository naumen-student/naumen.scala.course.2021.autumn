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
    def prettyBooleanFormatter1(x: Any): String = {
        if (x.isInstanceOf[Boolean]) {
            if (x.asInstanceOf[Boolean]) return "правда" else return "ложь"
        }
        x.toString
    }

    def prettyBooleanFormatter2(x: Any): String = {
        x match {
            case boolX: Boolean =>
                if (boolX) "правда" else "ложь"
            case _ => x.toString
        }
    }

    def prettyBooleanFormatter3(x: Any): String = {
        if (x.getClass.getSimpleName == "Boolean") {
            if (x.asInstanceOf[Boolean]) return "правда" else return "ложь"
        }
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
        var maxValue = Int.MinValue
        for {number <- xs if number > maxValue} maxValue = number
        maxValue
    }

    def max2(xs: Seq[Int]): Seq[Int] = {
        var resList = Seq[Int]()
        if (xs.nonEmpty) {resList = resList :+ max1(xs)}
        resList
    }

    def max3(xs: Seq[Int]): Option[Int] = {
        if (xs.isEmpty) {return None}
        Some(max1(xs))
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
    class MyIterator(elements: Seq[Int]) extends Iterator[Int] {
        private var index = 0

        override def hasNext: Boolean = {
            index < elements.length
        }

        override def next(): Int = {
            val element = elements(index)
            index += 1
            element
        }
    }

    class MyType(elements: Seq[Int]) extends Iterable[Int] {
        override def iterator: Iterator[Int] = {
            new MyIterator(elements)
        }
    }

    def sum1(x: Int, y: Int): Int = {
        val args = Seq(x, y)
        sumIntegers(args)
    }
    def sum2(x: Int, y: Int): Int = {
        val args = List(x, y)
        sumIntegers(args)
    }
    def sum3(x: Int, y: Int): Int = {
        val args = new MyType(Seq(x, y))
        sumIntegers(args)
    }

}
