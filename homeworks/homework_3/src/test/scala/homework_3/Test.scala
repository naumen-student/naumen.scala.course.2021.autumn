package homework_3

import utest._

object Test extends TestSuite{

    val tests: Tests = Tests{
        'test_formatter_true - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
        }

        'test_formatter_false - {
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
        }

        'test_formatter_not_bool - {
            assert(Exercises.prettyBooleanFormatter1(12) == "12")
            assert(Exercises.prettyBooleanFormatter2(3.14) == "3.14")
            assert(Exercises.prettyBooleanFormatter3(List()) == "List()")
        }

        'test_max_return_int - {
            val coll = List(1, 5, 2, 22, 3, 8)
            val empty = List()

            assert(Exercises.max1(coll) == 22)
            assert(Exercises.max1(empty) == 0)
        }

        'test_max_return_seq - {
            val coll = List(1, 5, 2, 22, 3, 8)
            val empty = List()

            assert(Exercises.max2(coll) == Seq(22))
            assert(Exercises.max2(empty) == Seq())
        }

        'test_max_return_maybe - {
            val coll = List(1, 5, 2, 22, 3, 8)
            val empty = List()

            assert(Exercises.max3(coll).contains(22))
            assert(Exercises.max3(empty).isEmpty)
        }

        'test_sum_1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-5, 5) == 0)
            assert(Exercises.sum1(-5, -2) == -7)
        }

        'test_sum_2 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(-5, 5) == 0)
            assert(Exercises.sum2(-5, -2) == -7)
        }

        'test_sum_3 - {
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum3(-5, 5) == 0)
            assert(Exercises.sum3(-5, -2) == -7)
        }
    }
}
