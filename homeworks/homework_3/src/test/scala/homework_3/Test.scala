package homework_3

import utest._

object Test extends TestSuite{


    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'prettyBooleanFormatter1 - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            val numStr = "123"
            assert(Exercises.prettyBooleanFormatter1(123) == numStr)
        }

        'prettyBooleanFormatter2 - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            val numStr = "123"
            assert(Exercises.prettyBooleanFormatter2(123) == numStr)
        }

        'max1 - {
            assert(Exercises.max1(Seq(1, 2, 16)) == 16)
            assert(Exercises.max1(Seq()) == Int.MinValue)
            assert(Exercises.max1(Seq(-3, -666, 0)) == 0)
        }

        'max2 - {
            assert(Exercises.max2(Seq(1, 2, 16)) == Seq(16))
            assert(Exercises.max2(Seq()) == Seq(Int.MinValue))
            assert(Exercises.max2(Seq(-3, -666, 0)) == Seq(0))
        }

        'max3 - {
            assert(Exercises.max3(Seq(1, 2, 16)) == Option(16))
            assert(Exercises.max3(Seq()) == Option(Int.MinValue))
            assert(Exercises.max3(Seq(-3, -666, 0)) == Option(0))
        }
    }
}
