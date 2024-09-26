package homework_3

import utest._

object Test extends TestSuite{

  val tests = Tests{
    'prettyBooleanFormatterTrueBool - {
      val trueStr = "правда"
      assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
      assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
    }

    'prettyBooleanFormatterFalseBool - {
      val falseStr = "ложь"
      assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
      assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
    }

    'prettyBooleanFormatterNotBool - {
      val number = 500
      assert(Exercises.prettyBooleanFormatter1(number) == "500")
      assert(Exercises.prettyBooleanFormatter2(number) == "500")
      assert(Exercises.prettyBooleanFormatter3(number) == "500")

      val string = "notBoolean!"
      assert(Exercises.prettyBooleanFormatter1(string) == "notBoolean!")
      assert(Exercises.prettyBooleanFormatter2(string) == "notBoolean!")
      assert(Exercises.prettyBooleanFormatter3(string) == "notBoolean!")
    }

    'maxNotEmptyTest - {
      val numbers = Seq(1, 3, 500, 3, 22)

      assert(Exercises.max1(numbers) == 500)
      assert(Exercises.max2(numbers) == Seq(500))
      assert(Exercises.max3(numbers).contains(500))
    }

    'maxEmptyTest - {
      val numbers = Seq()

      assert(Exercises.max1(numbers) == Int.MinValue)
      assert(Exercises.max2(numbers) == Seq())
      assert(Exercises.max3(numbers).isEmpty)
    }

    'sumTest - {
      val first = 5
      val second = 7
      val sum = 12

      assert(Exercises.sum1(first, second) == sum)
      assert(Exercises.sum2(first, second) == sum)
      assert(Exercises.sum3(first, second) == sum)
    }
  }
}
