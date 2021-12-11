package homework_3

import utest._

object Test extends TestSuite {

    val tests = Tests {
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(Seq()) == Seq().toString())
            assert(Exercises.prettyBooleanFormatter1(5) == "5")
            assert(Exercises.prettyBooleanFormatter1(1.0) == "1.0")
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(Seq()) == Seq().toString())
            assert(Exercises.prettyBooleanFormatter2(5) == "5")
            assert(Exercises.prettyBooleanFormatter2(1.0) == "1.0")
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(Seq()) == Seq().toString())
            assert(Exercises.prettyBooleanFormatter3(5) == "5")
            assert(Exercises.prettyBooleanFormatter3(1.0) == "1.0")
        }

        'test_maxes - {
            val testCases = List(
                Seq(2, 3, 4, 5),
                Seq(-3, -6, 1),
                Seq(1, -8),
                Seq(),
                Seq(11, Int.MaxValue)
            )
            val result1 = List(6, 6, 2, Int.MinValue, Int.MaxValue)
            val result2 = List(Seq(6), Seq(6), Seq(2), Seq(), Seq(Int.MaxValue))
            val result3 = List(Some(6), Some(6), Some(2), None, Some(Int.MaxValue))

            for (i <- 0 to 6) {
                val x1 = Exercises.max1(testCases(i))
                val x2 = Exercises.max2(testCases(i))
                val x3 = Exercises.max3(testCases(i))
                val res1 = result1(i)
                val res2 = result2(i)
                val res3 = result3(i)
                assert(x1 == res1)
                assert(x2 == res2)
                assert(x3 == res3)
            }
        }


        'test_sum - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(2, 0) == 2)
            assert(Exercises.sum1(-3, 2) == -1)

            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(2, 0) == 2)
            assert(Exercises.sum2(-3, 2) == -1)

            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(2, 0) == 2)
            assert(Exercises.sum2(-3, 2) == -1)
        }
    }
}