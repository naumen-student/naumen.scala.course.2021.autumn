package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }

        'prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(0) == "0")
            assert(Exercises.prettyBooleanFormatter1('a') == "a")
        }

        'prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(0) == "0")
            assert(Exercises.prettyBooleanFormatter2('a') == "a")
        }

        'prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(0) == "0")
            assert(Exercises.prettyBooleanFormatter3('a') == "a")
        }

        'max1 - {
            assert(Exercises.max1(Seq(1, 3, 2, 5)) == 5)
            assert(Exercises.max1(Seq(-1, -5)) == -1)
            assert(Exercises.max1(Seq(9, 1, 9)) == 9)
            assert(Exercises.max1(Seq()) == 0)

        }

        'max2 - {
            assert(Exercises.max2(Seq(1, 3, 2, 5)) == Seq(5))
            assert(Exercises.max2(Seq(-1, -5)) == Seq(-1))
            assert(Exercises.max2(Seq(9, 1, 9)) == Seq(9))
            assert(Exercises.max2(Seq()) == Seq[Int]())
        }

        'max3 - {
            assert(Exercises.max3(Seq(1, 3, 2, 5)) == Option(5))
            assert(Exercises.max3(Seq(-1, -5)) == Option(-1))
            assert(Exercises.max3(Seq(9, 1, 9)) == Option(9))
            assert(Exercises.max3(Seq()) == None)
        }

        'sum1 - {
            assert(Exercises.sum1(10, 5) == 15)
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(100, 100) == 200)
            assert(Exercises.sum1(15, 15) == 30)
        }

        'sum2 - {
            assert(Exercises.sum2(10, 5) == 15)
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum2(100, 100) == 200)
            assert(Exercises.sum2(15, 15) == 30)
        }
        'sum3 - {
            assert(Exercises.sum3(10, 5) == 15)
            assert(Exercises.sum3(0, 0) == 0)
            assert(Exercises.sum3(100, 100) == 200)
            assert(Exercises.sum3(15, 15) == 30)
        }
    }
}
