package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_1_bool_1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
        }

        'test_1_any_1 - {
            assert(Exercises.prettyBooleanFormatter1(42) == "42")
            assert(Exercises.prettyBooleanFormatter1("pravda") == "pravda")
        }

        'test_1_any_bool_1 - {
            assert(Exercises.prettyBooleanFormatter1(42) == "42")
            assert(Exercises.prettyBooleanFormatter1(true) == "правда")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1("ложь") == "ложь")
        }

        'test_1_bool_2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
        }

        'test_1_any_2 - {
            assert(Exercises.prettyBooleanFormatter2(42) == "42")
            assert(Exercises.prettyBooleanFormatter2("pravda") == "pravda")
        }

        'test_1_any_bool_2 - {
            assert(Exercises.prettyBooleanFormatter2(42) == "42")
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2("ложь") == "ложь")
        }

        'test_1_bool_3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
        }

        'test_1_any_3 - {
            assert(Exercises.prettyBooleanFormatter3(42) == "42")
            assert(Exercises.prettyBooleanFormatter3("pravda") == "pravda")
        }

        'test_1_any_bool_3 - {
            assert(Exercises.prettyBooleanFormatter3(42) == "42")
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3("ложь") == "ложь")
        }

        'test_2_1 - {
            assert(Exercises.max1(Seq()) == Int.MinValue)
            assert(Exercises.max1(Seq(5, 32, 4, 102, -23, 43)) == 102)
            assert(Exercises.max1(Seq(11, 11, 11, 11)) == 11)
        }

        'test_2_2 - {
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(5, 32, 4, 102, -23, 43)) == Seq(102))
            assert(Exercises.max2(Seq(11, 11, 11, 11)) == Seq(11))
        }

        'test_2_3 - {
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max3(Seq(5, 32, 4, 102, -23, 43)) == Some(102))
            assert(Exercises.max3(Seq(11, 11, 11, 11)) == Some(11))
        }

        'test_3_1 - {
            assert(Exercises.sum1(0, 0) == 0)
        }

        'test_3_2 - {
            assert(Exercises.sum2(-23, 64) == 41)
        }

        'test_3_3 - {
            assert(Exercises.sum3(0, 77) == 77)
        }
    }
}
