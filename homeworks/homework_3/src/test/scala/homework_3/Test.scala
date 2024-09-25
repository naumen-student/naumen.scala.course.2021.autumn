package homework_3

import utest._

object Test extends TestSuite {

  val tests = Tests {
    'test_example - {
      val trueStr = "правда"
      assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
    }

    'test_prettyFromater1 - {
      assert(Exercises.prettyBooleanFormatter1(true) == "правда")
      assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
      assert(Exercises.prettyBooleanFormatter1("qwer") == "qwer")
      assert(Exercises.prettyBooleanFormatter2(42) == "42")
      assert(Exercises.prettyBooleanFormatter1(List()) == List().toString)
    }

    'test_prettyFromater2 - {
      assert(Exercises.prettyBooleanFormatter2(true) == "правда")
      assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
      assert(Exercises.prettyBooleanFormatter2("qwer") == "qwer")
      assert(Exercises.prettyBooleanFormatter2(42) == "42")
      assert(Exercises.prettyBooleanFormatter2(List()) == List().toString)
    }

    'test_prettyFromater3 - {
      val str = Exercises.prettyBooleanFormatter3(true)
      assert(str == "правда")
      assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
      assert(Exercises.prettyBooleanFormatter3("qwer") == "qwer")
      assert(Exercises.prettyBooleanFormatter2(42) == "42")
      assert(Exercises.prettyBooleanFormatter3(List()) == List().toString)
    }

    'test_max1 - {
      assert(Exercises.max1(Seq()) == Int.MinValue)
      assert(Exercises.max1(Seq(1, -3, 15, 5)) == 15)
      assert(Exercises.max1(Seq(-10, -3, -15, -5)) == -3)
    }

    'test_max2 - {
      assert(Exercises.max2(Seq()) == Seq())
      assert(Exercises.max2(Seq(1, -3, 15, 5)) == Seq(15))
      assert(Exercises.max2(Seq(-10, -3, -15, -5)) == Seq(-3))
    }

    'test_max3 - {
      assert(Exercises.max3(Seq()) == Option.empty)
      assert(Exercises.max3(Seq(1, -3, 15, 5)) == Option(15))
      assert(Exercises.max3(Seq(-10, -3, -15, -5)) == Option(-3))
    }

    'test_sum1 - {
      assert(Exercises.sum1(0, 0) == 0)
      assert(Exercises.sum1(1, 1) == 2)
      assert(Exercises.sum1(-100, 1000) == 900)
      assert(Exercises.sum1(-111, -200) == -311)
    }

    'test_sum2 - {
      assert(Exercises.sum2(0, 0) == 0)
      assert(Exercises.sum2(1, 1) == 2)
      assert(Exercises.sum2(-100, 1000) == 900)
      assert(Exercises.sum2(-111, -200) == -311)
    }

    'test_sum1 - {
      assert(Exercises.sum3(0, 0) == 0)
      assert(Exercises.sum3(1, 1) == 2)
      assert(Exercises.sum3(-100, 1000) == 900)
      assert(Exercises.sum3(-111, -200) == -311)
    }
  }
}
