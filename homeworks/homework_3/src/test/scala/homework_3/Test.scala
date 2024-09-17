package homework_3

import utest._

object Test extends TestSuite {

    val tests = Tests {
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }

        'test_prettyBooleanFormatter1 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(1) == "1")
        }

        'test_prettyBooleanFormatter2 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(2.56) == "2.56")
        }

        'test_prettyBooleanFormatter3 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(42) == "42")
        }

        'test_max1 - {
            assert(Exercises.max1(Seq()) == 0)
            assert(Exercises.max1(Seq(15, -2, 6)) == 15)
            assert(Exercises.max1(Seq(-10, 11, 11)) == 11)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(15, -2, 6)) == Seq(15))
            assert(Exercises.max2(Seq(-10, 11, 11)) == Seq(11))
        }

        'test_max3 - {
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max3(Seq(15, -2, 6)) == Some(15))
            assert(Exercises.max3(Seq(-10, 11, 11)) == Some(11))
        }

        'test_sum1 - {
            assert(Exercises.sum1(0, 1) == 1)
            assert(Exercises.sum1(10, 20) == 30)
            assert(Exercises.sum1(7, 7) == 14)
        }

        'test_sum2 - {
            assert(Exercises.sum2(0, 1) == 1)
            assert(Exercises.sum2(10, 20) == 30)
            assert(Exercises.sum2(7, 7) == 14)
        }

        'test_sum3 - {
            assert(Exercises.sum3(0, 1) == 1)
            assert(Exercises.sum3(10, 20) == 30)
            assert(Exercises.sum3(7, 7) == 14)
        }
    }
}
