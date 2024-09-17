package homework_3

object Exercises {

     /*
     Задание №1
     */

    def prettyBooleanFormatter1(anyType: Any): String = {
          if (anyType.isInstanceOf[Boolean] ) {
              if (anyType == true) "правда" else "ложь"
          } else anyType.toString
    }

    def prettyBooleanFormatter2(anyType: Any): String = {
        anyType match {
             case true => "правда"
             case false => "ложь"
             case _ => anyType.toString
        }
    }

    def prettyBooleanFormatter3(anyType: Any): String = {
       if (anyType.getClass.getName == "java.lang.Boolean") {
           if (anyType.asInstanceOf[Boolean]) "правда" else "ложь"
       } else anyType.toString
    }

    /*
    Задание №2
    */
    def max1(xs: Seq[Int]): Int = {
        if (xs.isEmpty) Int.MinValue else xs.max
    }

    def max2(xs: Seq[Int]): Seq[Int] = {
        if (xs.isEmpty) Seq() else Seq(xs.max);
    }

    def max3(xs: Seq[Int]): Option[Int] = {
        if (xs.isEmpty) None else Some(xs.max)
    }

    /*
    Задание №3
    */
    def sumIntegers[CollectionType <: Iterable[Int]] (xs: CollectionType): Int = xs.sum

    class SomeIterableClass (x : Int, y : Int) extends Iterable[Int] {
        override def iterator: Iterator[Int] = List(x, y).toIterator;
    }

    def sum1(x: Int, y: Int): Int = sumIntegers(List (x, y))

    def sum2(x: Int, y: Int): Int = sumIntegers(Iterable[Int] (x, y))

    def sum3(x: Int, y: Int): Int = sumIntegers(new SomeIterableClass(x, y))

}
