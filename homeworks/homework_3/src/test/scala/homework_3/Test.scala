package homework_3

import homework_3.Exercises.{max1, max2, max3, prettyBooleanFormatter1, prettyBooleanFormatter2, prettyBooleanFormatter3, sum1, sum2, sum3}
import utest._

object Test extends TestSuite {

  val tests = Tests {

    'test_exercise_1 - {
      assert(prettyBooleanFormatter1(1).equals("1"))
      assert(prettyBooleanFormatter1(true).equals("правда"))
      assert(prettyBooleanFormatter1(false).equals("ложь"))
      assert(prettyBooleanFormatter1(2.5).equals("2.5"))
      assert(prettyBooleanFormatter1("Красное").equals("Красное"))

      assert(prettyBooleanFormatter2(1).equals("1"))
      assert(prettyBooleanFormatter2(true).equals("правда"))
      assert(prettyBooleanFormatter2(false).equals("ложь"))
      assert(prettyBooleanFormatter2(2.5).equals("2.5"))
      assert(prettyBooleanFormatter2("Красное").equals("Красное"))

      assert(prettyBooleanFormatter3(1).equals("1"))
      assert(prettyBooleanFormatter3(true).equals("правда"))
      assert(prettyBooleanFormatter3(false).equals("ложь"))
      assert(prettyBooleanFormatter3(2.5).equals("2.5"))
      assert(prettyBooleanFormatter3("Красное").equals("Красное"))
    }
    'test_exercise_2 - {
      assert(max1(Seq(-1, -2, -3, -4, -4, -4, -4, -5, -5, -5, -5, -5) ) == -1)
      assert(max1(Seq(1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5) ) == 5)
      assert(max1(Seq()) == 0)

      assert(max2(Seq(-1, -2, -3, -4, -4, -4, -4, -5, -5, -5, -5, -5)).length == 1 && max2(Seq(-1, -2, -3, -4, -4, -4, -4, -5, -5, -5, -5, -5)).head == -1)
      assert(max2(Seq(1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5)).length == 1 && max2(Seq(1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5)).head == 5)
      assert(max2(Seq()).isEmpty)

      assert(max3(Seq(-1, -2, -3, -4, -4, -4, -4, -5, -5, -5, -5, -5)).isDefined && max3(Seq(-1, -2, -3, -4, -4, -4, -4, -5, -5, -5, -5, -5)).get == -1)
      assert(max3(Seq(1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5)).isDefined && max3(Seq(1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5)).get == 5)
      assert(max3(Seq()).isEmpty)
    }

    'test_exercise_3 - {
      assert(sum1(1,2) == 3)
      assert(sum1(-1, 5)== 4)
      assert(sum1(-5, 5) == 0)
      assert(sum1(5, 0) == 5)

      assert(sum2(1,2) == 3)
      assert(sum2(-1, 5)== 4)
      assert(sum2(-5, 5) == 0)
      assert(sum2(5, 0) == 5)

      assert(sum3(1,2) == 3)
      assert(sum3(-1, 5)== 4)
      assert(sum3(-5, 5) == 0)
      assert(sum3(5, 0) == 5)
    }
  }
}
