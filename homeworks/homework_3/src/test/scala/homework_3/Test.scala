package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(List(1, 2, 3)) == "List(1, 2, 3)")
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(123) == "123")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(Seq()) == "List()")
        }

        'test_max1 - {
            assert(Exercises.max1(Seq()) == 0)
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Seq(-5, 0, 42)) == 42)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq()) == Seq(0))
            assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3))
            assert(Exercises.max2(Seq(-5, 0, 42)) == Seq(42))
        }

        'test_max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1, 2, 3)).contains(3))
            assert(Exercises.max3(Seq(-5, 0, 42)).contains(42))
        }

        'test_sum_1 - {
            assert(Exercises.sum1(0, 1) == 1)
            assert(Exercises.sum1(10, 10) == 20)
            assert(Exercises.sum1(-10, -10) == -20)
        }

        'test_sum_2 - {
            assert(Exercises.sum2(0, 1) == 1)
            assert(Exercises.sum2(10, 10) == 20)
            assert(Exercises.sum2(-10, -10) == -20)
        }

        'test_sum_3 - {
            assert(Exercises.sum3(0, 1) == 1)
            assert(Exercises.sum3(10, 10) == 20)
            assert(Exercises.sum3(-10, -10) == -20)
        }
    }
}
