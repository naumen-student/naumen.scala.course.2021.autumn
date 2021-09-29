package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }

        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(123) == "123")
            assert(Exercises.prettyBooleanFormatter1(List("a", "b")) == "List(a, b)")
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2("abc") == "abc")
            assert(Exercises.prettyBooleanFormatter2(List(1, 2, 3)) == "List(1, 2, 3)")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3('a') == "a")
            assert(Exercises.prettyBooleanFormatter3(Tuple2(1, "b")) == "(1,b)")
        }

        'test_max1 - {
            assert(Exercises.max1(Seq()) == Int.MinValue)
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(-10, 44, 44)) == 44)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq()).equals(Seq()))
            assert(Exercises.max2(Seq(-2)).equals(Seq(-2)))
            assert(Exercises.max2(Seq(-11, 22, 3)).equals(Seq(22)))
        }

        'test_max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(9, 51)).contains(51))
            assert(Exercises.max3(Seq(23, -1, 5)).contains(23))
        }

        'test_sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-100, 27) == -73)
            assert(Exercises.sum1(0, 19) == 19)
        }

        'test_sum2 - {
            assert(Exercises.sum2(102, 221) == 323)
            assert(Exercises.sum2(-21, 2) == -19)
            assert(Exercises.sum2(34, -19) == 15)
        }

        'test_sum3 - {
            assert(Exercises.sum3(8, 2) == 10)
            assert(Exercises.sum3(0, -27) == -27)
            assert(Exercises.sum3(32, 186) == 218)
        }
    }
}
