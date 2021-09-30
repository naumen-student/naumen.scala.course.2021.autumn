package homework_3

import utest._

object Test extends TestSuite{

    def testPrettyBooleanFormatter(formatter: Any => String): Unit = {
        assert(formatter(true) == "правда")
        assert(formatter(false) == "ложь")
        assert(formatter("hello world") == "hello world")
        assert(formatter(1) == "1")
        assert(formatter(List(1, 2, 3, 4)) == "List(1, 2, 3, 4)")
    }

    def testSum(sum: (Int, Int) => Int): Unit = {
        assert(sum(0, 0) == 0)
        assert(sum(1, 2) == 3)
        assert(sum(-2, 1) == -1)
        assert(sum(2, -1) == 1)
    }

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }

        'test_prettyBooleanFormatter1 - testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter1)
        'test_prettyBooleanFormatter2 - testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter2)
        'test_prettyBooleanFormatter3 - testPrettyBooleanFormatter(Exercises.prettyBooleanFormatter3)

        'test_max1 - {
            assert(Exercises.max1(Seq()) == -1)
            assert(Exercises.max1(Seq(1)) == 1)
            assert(Exercises.max1(Seq(1, -4, 3)) == 3)
        }
        'test_max2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1)) == Seq(1))
            assert(Exercises.max2(Seq(1, -4, 3)) == Seq(3))
        }
        'test_max3 - {
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(1)).contains(1))
            assert(Exercises.max3(Seq(1, -4, 3)).contains(3))
        }

        'test_sum1 - testSum(Exercises.sum1)
        'test_sum2 - testSum(Exercises.sum2)
        'test_sum3 - testSum(Exercises.sum3)
    }
}
