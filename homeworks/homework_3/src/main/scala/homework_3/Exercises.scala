package homework_3

object Exercises {

    /* Задание №1 */
    def prettyBooleanFormatter1(x: Any): String = {
        if (x.isInstanceOf[Boolean]) {
            if (x.asInstanceOf[Boolean]) "правда"
            else "ложь"
        }
        else x.toString
    }

    def prettyBooleanFormatter2(x: Any): String = {
        x match {
            case true => "правда"
            case false => "ложь"
            case _ => x.toString
        }
    }

    def prettyBooleanFormatter3(x: Any): String = {
        if (x.getClass.getName.contains("Boolean")) {
            if (x.asInstanceOf[Boolean]) "правда"
            else "ложь"
        }
        else x.toString
    }

    /* Задание №2 */
    def max1(xs: Seq[Int]): Int = {
        try {
            xs.max
        }
        catch {
            case e: Exception => return -1
        }
    }

    def max2(xs: Seq[Int]): Seq[Int] = if (xs.isEmpty) Seq() else Seq(xs.max)

    def max3(xs: Seq[Int]): Option[Int] = if (xs.isEmpty) None else Option(xs.max)

    /* Задание №3 */
    def sumIntegers[CollectionType <: Iterable[Int]](xs: CollectionType): Int = xs.sum

    case class MyIterator(x: Int, y: Int) extends Iterable[Int] {
        override def iterator: Iterator[Int] = Iterator(x, y)
    }

    def sum1(x: Int, y: Int): Int = sumIntegers(Set(x,y))
    def sum2(x: Int, y: Int): Int = sumIntegers(MyIterator(x,y))
    def sum3(x: Int, y: Int): Int = sumIntegers(List(x,y))

}
