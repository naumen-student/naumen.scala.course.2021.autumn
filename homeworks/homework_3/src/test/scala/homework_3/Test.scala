package homework_3

import utest._

object Test extends TestSuite{

  val prettyBooleans = Seq(
    (x: Any) => Exercises.prettyBooleanFormatter1(x),
    (x: Any) => Exercises.prettyBooleanFormatter2(x),
    (x: Any) => Exercises.prettyBooleanFormatter3(x)
  )

  val sums = Seq(
    (x: Int, y: Int) => Exercises.sum1(x, y),
    (x: Int, y: Int) => Exercises.sum2(x, y),
    (x: Int, y: Int) => Exercises.sum3(x, y)
  )

  val tests = Tests{
    'prettyBooleanFormatter_OnBoolean - {
      val trueStr = "правда"
      prettyBooleans.foreach(f => assert(f(true) == trueStr))

      val falseStr = "ложь"
      prettyBooleans.foreach(f => assert(f(false) == falseStr))
    }

    'prettyBooleanFormatter_OnNotBoolean - {
      prettyBooleans.foreach(f => assert(f(1) == "1"))
      prettyBooleans.foreach(f => assert(f("string") == "string"))
      prettyBooleans.foreach(f => assert(f(1.5) == "1.5"))
    }

    'max_OnEmptyInput - {
      val numbers = Seq()

      assert(Exercises.max1(numbers) == Int.MinValue)
      assert(Exercises.max2(numbers) == Seq())
      assert(Exercises.max3(numbers).isEmpty)
    }

    'max_OnNotEmptyInput - {
      val numbers = Seq(1, 3, 2)

      assert(Exercises.max1(numbers) == 3)
      assert(Exercises.max2(numbers) == Seq(3))
      assert(Exercises.max3(numbers).contains(3))
    }

    'sum - {
      sums.foreach(sum => assert(sum(1, 2) == 3))
    }
  }
}
