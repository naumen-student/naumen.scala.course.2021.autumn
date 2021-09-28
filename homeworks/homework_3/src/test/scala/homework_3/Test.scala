package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(21) == "21")

            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(21) == "21")

            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(21) == "21")
        }

        'test_max - {
            assert(Exercises.max1(Seq()) == -1)
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(-2, 0, 0)) == 0)

            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(-2, 0, 0)) == Seq(0))

            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1)).get == 1)
            assert(Exercises.max3(Seq(-2, 0, 0)).get == 0)

        }

        'test_sum - {
            assert(Exercises.sum1(20, 5) == 25)
            assert(Exercises.sum1(-7, 7) == 0)
            assert(Exercises.sum1(-7, 8) == 1)

            assert(Exercises.sum2(20, 5) == 25)
            assert(Exercises.sum2(-7, 7) == 0)
            assert(Exercises.sum2(-7, 8) == 1)

            assert(Exercises.sum3(20, 5) == 25)
            assert(Exercises.sum3(-7, 7) == 0)
            assert(Exercises.sum3(-7, 8) == 1)
        }
    }
}
