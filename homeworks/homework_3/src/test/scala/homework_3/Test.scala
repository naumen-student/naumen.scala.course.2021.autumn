package homework_3

import utest._

object Test extends TestSuite{

    val tests: Tests = Tests{
        Symbol("test_prettyBooleanFormatter1") - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(1) == "1")
            assert(Exercises.prettyBooleanFormatter1("Word") == "Word")
        }
        Symbol("test_prettyBooleanFormatter2") - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(1) == "1")
            assert(Exercises.prettyBooleanFormatter2("Word") == "Word")
        }
        Symbol("test_prettyBooleanFormatter3") - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(1) == "1")
            assert(Exercises.prettyBooleanFormatter3("Word") == "Word")
        }
        Symbol("test_max1") - {
            assert(Exercises.max1(Seq(1, 2, 3, 4, 5)) == 5)
            assert(Exercises.max1(Seq()) == Int.MinValue)
            assert(Exercises.max1(Seq(-10, -2, 20, -1, 5)) == 20)
        }
        Symbol("test_max2") - {
            assert(Exercises.max2(Seq(1, 2, 3, 4, 5)) == Seq(5))
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(-10, -2, 20, -1, 5)) == Seq(20))
        }
        Symbol("test_max3") - {
            assert(Exercises.max3(Seq(1, 2, 3, 4, 5)).contains(5))
            assert(Exercises.max3(Seq()).isEmpty)
            assert(Exercises.max3(Seq(-10, -2, 20, -1, 5)).contains(20))
        }
        Symbol("test_sum") - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum3(1, 2) == 3)
        }
    }
}
