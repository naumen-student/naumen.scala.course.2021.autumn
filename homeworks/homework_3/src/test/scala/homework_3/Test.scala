package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(42) == "42")
            assert(Exercises.prettyBooleanFormatter1(Seq()) == "List()")
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(42) == "42")
            assert(Exercises.prettyBooleanFormatter2(Seq()) == "List()")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(42) == "42")
            assert(Exercises.prettyBooleanFormatter3(Seq()) == "List()")
        }

        'test_max1 - {
            assert(Exercises.max1(Seq()) == -1)
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max1(Seq(-5, -12, 53, 0)) == 53)
        }

        'test_max2 - {
            assert(Exercises.max2(Seq()) == Seq(-1))
            assert(Exercises.max2(Seq(1, 2, 3, 5, 1)) == Seq(3))
            assert(Exercises.max2(Seq(-5, 0, 42, 10, 2, 12)) == Seq(42))
        }

        'test_max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1, 99999)).contains(99999))
            assert(Exercises.max3(Seq(-1, 1, -1)).contains(1))
        }

        'test_sum_1 - {
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-5, 2) == -3)
            assert(Exercises.sum1(-2, -5) == -7)
        }

        'test_sum_2 - {
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-5, 2) == -3)
            assert(Exercises.sum1(-2, -5) == -7)
        }

        'test_sum_3 - {
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-5, 2) == -3)
            assert(Exercises.sum1(-2, -5) == -7)
        }
    }
}
