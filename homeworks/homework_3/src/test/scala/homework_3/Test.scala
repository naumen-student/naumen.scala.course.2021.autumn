package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'prettyBooleanFormatter1 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1("добрый вечер") == "добрый вечер")
            assert(Exercises.prettyBooleanFormatter1(Seq(1, 2, 3)) == "List(1, 2, 3)")
        }

        'prettyBooleanFormatter2 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2("добрый вечер") == "добрый вечер")
            assert(Exercises.prettyBooleanFormatter2(Seq(1, 2, 3)) == "List(1, 2, 3)")
        }

        'prettyBooleanFormatter3 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3("добрый вечер") == "добрый вечер")
            assert(Exercises.prettyBooleanFormatter3(Seq(1, 2, 3)) == "List(1, 2, 3)")
        }

        'max1 - {
            assert(Exercises.max1(Seq()) == 0)
            assert(Exercises.max1(Seq(1, 3, 10, 4, 100, 100)) == 100)
            assert(Exercises.max1(Seq(1)) == 1)
        }

        'max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1, 3, 10, 4, 100, 100)) == Seq(100))
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(-1, -2, -10, 0)) == Seq(0))
        }

        'max3 - {
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max3(Seq(1, 3, 10, 4, 100, 100)) == Some(100))
            assert(Exercises.max3(Seq(1)) == Some(1))
            assert(Exercises.max3(Seq(-1, -2, -10, 0)) == Some(0))
        }

        'sum1 - {
            assert(Exercises.sum1(5, 6) == 11)
            assert(Exercises.sum1(-10, 10) == 0)
            assert(Exercises.sum1(-10, -10) == -20)
        }

        'sum2 - {
            assert(Exercises.sum2(5, 6) == 11)
            assert(Exercises.sum2(-10, 10) == 0)
            assert(Exercises.sum2(-10, -10) == -20)
        }

        'sum3 - {
            assert(Exercises.sum3(5, 6) == 11)
            assert(Exercises.sum3(-10, 10) == 0)
            assert(Exercises.sum3(-10, -10) == -20)
        }
    }
}
