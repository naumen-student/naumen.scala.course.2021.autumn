package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_formatters - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)

            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)

            val intStr = "1"
            assert(Exercises.prettyBooleanFormatter1(1) == intStr)
            assert(Exercises.prettyBooleanFormatter2(1) == intStr)
            assert(Exercises.prettyBooleanFormatter3(1) == intStr)
        }

        'test_max1 - {
            assert(Exercises.max1(Seq()) == Int.MinValue)
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(1, 2, 3, 5, 4)) == 5)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(1, 2, 3, 5, 4)) == Seq(5))
        }

        'test_max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1)).contains(1))
            assert(Exercises.max3(Seq(1, 2, 3, 5, 4)).contains(5))
        }

        'test_sum1 - {
            assert(Exercises.sum1(1, 0) == 1)
            assert(Exercises.sum1(0, 1) == 1)
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(-1, 0) == -1)
            assert(Exercises.sum1(-1, -2) == -3)
            assert(Exercises.sum1(-5, 7) == 2)
            assert(Exercises.sum1(-5, 5) == 0)
        }

        'test_sum2 - {
            assert(Exercises.sum2(1, 0) == 1)
            assert(Exercises.sum2(0, 1) == 1)
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum2(-1, 0) == -1)
            assert(Exercises.sum2(-1, -2) == -3)
            assert(Exercises.sum2(-5, 7) == 2)
            assert(Exercises.sum2(-5, 5) == 0)
        }

        'test_sum3 - {
            assert(Exercises.sum3(1, 0) == 1)
            assert(Exercises.sum3(0, 1) == 1)
            assert(Exercises.sum3(0, 0) == 0)
            assert(Exercises.sum3(-1, 0) == -1)
            assert(Exercises.sum3(-1, -2) == -3)
            assert(Exercises.sum3(-5, 7) == 2)
            assert(Exercises.sum3(-5, 5) == 0)
        }
    }
}
