package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        val trueStr = "правда"
        val falseStr = "ложь"
        'prettyBooleanFormatter1_test - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(3) == "3")
        }
        'prettyBooleanFormatter2_test - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(3) == "3")
        }
        'prettyBooleanFormatter3_test - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(3) == "3")
        }

        'max1_test - {
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(5,3,-7,1,-6,34,8,-8)) == 34)
            assert(Exercises.max1(Seq()) == Int.MinValue)
        }
        'max2_test - {
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(5,3,-7,1,-6,34,8,-8)) == Seq(34))
            assert(Exercises.max2(Seq()) == Seq())
        }
        'max3_test - {
            assert(Exercises.max3(Seq(1)) == Some(1))
            assert(Exercises.max3(Seq(5,3,-7,1,-6,34,8,-8)) == Some(34))
            assert(Exercises.max3(Seq()) == None)
        }

        'sum1_test - {
            assert(Exercises.sum1(7, 14) == 21)
            assert(Exercises.sum1(126, -84) == 42)
            assert(Exercises.sum1(Int.MinValue, Int.MaxValue) == -1)
        }
        'sum2_test - {
            assert(Exercises.sum2(7, 14) == 21)
            assert(Exercises.sum2(126, -84) == 42)
            assert(Exercises.sum2(Int.MinValue, Int.MaxValue) == -1)
        }
        'sum3_test - {
            assert(Exercises.sum3(7, 14) == 21)
            assert(Exercises.sum3(126, -84) == 42)
            assert(Exercises.sum3(Int.MinValue, Int.MaxValue) == -1)
        }
    }
}
