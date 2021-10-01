package homework_3

import utest._

object Test extends TestSuite{
    val trueStr = "правда"
    val falseStr = "ложь"

    val tests = Tests{
        'test_example - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1("abs") == "abs")
        }
        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2("abs") == "abs")
        }
        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3("abs") == "abs")
        }
        'test_max1 - {
            assert(Exercises.max1(Seq(1,3,5,2,100)) == 100)
            assert(Exercises.max1(Seq(-1,-2,-3,-4,-100)) == -1 )
            assert(Exercises.max1(Seq()) == Int.MinValue)
        }
        'test_max2 - {
            assert(Exercises.max2(Seq(1,3,5,2,100)) == Seq(100))
            assert(Exercises.max2(Seq(-1,-2,-3,-4,-100)) == Seq(-1))
            assert(Exercises.max2(Seq()) == Seq())
        }
        'test_max3 - {
            assert(Exercises.max3(Seq(1,3,5,2,100)) == Option(100))
            assert(Exercises.max3(Seq(-1,-2,-3,-4,-100)) == Option(-1))
            assert(Exercises.max3(Seq()).isEmpty)
        }
        'test_sum1 - {
            assert(Exercises.sum1(1,2) == 3)
            assert(Exercises.sum1(-1,1) == 0)
            assert(Exercises.sum1(-1,-11) == -12)
        }
        'test_sum2 - {
            assert(Exercises.sum2(1,2) == 3)
            assert(Exercises.sum2(-1,1) == 0)
            assert(Exercises.sum2(-1,-11) == -12)
        }
        'test_sum1 - {
            assert(Exercises.sum3(1,2) == 3)
            assert(Exercises.sum3(-1,1) == 0)
            assert(Exercises.sum3(-1,-11) == -12)
        }

    }
}
