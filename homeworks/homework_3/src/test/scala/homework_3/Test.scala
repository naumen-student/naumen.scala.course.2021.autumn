package homework_3

import utest._

object Test extends TestSuite{
    val trueStr = "правда"
    val falseStr = "ложь"
    val IntStr = "123"

    val tests = Tests{
        'test_example - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(123) == IntStr)
        }
        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(123) == IntStr)
        }
        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(123) == IntStr)
        }

        'test_max1 - {
            assert(Exercises.max1(Seq(2)) == 2)
            assert(Exercises.max1(Seq(-1)) == -1)
            assert(Exercises.max1(Seq(3, -3, -6)) == 3)
        }
        'test_max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(-1)) == Seq(-1))
            assert(Exercises.max2(Seq(100, 101, -6)) == Seq(101))
        }
        'test_max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(-1)).contains(-1))
            assert(Exercises.max3(Seq(0, 1, -6)).contains(1))
        }

        'test_sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-1, 2) == 1)
            assert(Exercises.sum1(0, 0) == 0)
        }
        'test_sum2 - {
            assert(Exercises.sum2(3, 3) == 6)
            assert(Exercises.sum2(-100, 200) == 100)
            assert(Exercises.sum2(0, 0) == 0)
        }
        'test_sum3 - {
            assert(Exercises.sum3(11, 22) == 33)
            assert(Exercises.sum3(-1, 1) == 0)
            assert(Exercises.sum3(0, 0) == 0)
        }
    }
}
