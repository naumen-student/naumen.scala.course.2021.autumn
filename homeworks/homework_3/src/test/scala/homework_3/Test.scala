package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter - {
            'first_realization - {
                assert(Exercises.prettyBooleanFormatter1(true) == "правда")
                assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
                assert(Exercises.prettyBooleanFormatter1(2) == "2")
                assert(Exercises.prettyBooleanFormatter1("2232131") == "2232131")
                assert(Exercises.prettyBooleanFormatter1(List(1, 2, 3)) == "List(1, 2, 3)")
            }
            'second_realization - {
                assert(Exercises.prettyBooleanFormatter2(true) == "правда")
                assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
                assert(Exercises.prettyBooleanFormatter2(2) == "2")
                assert(Exercises.prettyBooleanFormatter2("2232131") == "2232131")
                assert(Exercises.prettyBooleanFormatter2(List(1, 2, 3)) == "List(1, 2, 3)")
            }
            'third_realization - {
                assert(Exercises.prettyBooleanFormatter3(true) == "правда")
                assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
                assert(Exercises.prettyBooleanFormatter3(2) == "2")
                assert(Exercises.prettyBooleanFormatter3("2232131") == "2232131")
                assert(Exercises.prettyBooleanFormatter3(List(1, 2, 3)) == "List(1, 2, 3)")
            }
        }

        'test_max - {
            'first_realization - {
                assert(Exercises.max1(Seq(1, 2, 3)) == 3)
                assert(Exercises.max1(Seq(-4, -7, -2)) == -2)
                assert(Exercises.max1(Seq(900)) == 900)
                assert(Exercises.max1(Seq()) == Int.MinValue)
            }
            'second_realization - {
                assert(Exercises.max2(Seq(1, 2, 3)) == Seq(3))
                assert(Exercises.max2(Seq(-4, -7, -2)) == Seq(-2))
                assert(Exercises.max2(Seq(900)) == Seq(900))
                assert(Exercises.max2(Seq()) == Seq())
            }
            'third_realization - {
                assert(Exercises.max3(Seq(1, 2, 3)).get == 3)
                assert(Exercises.max3(Seq(-4, -7, -2)).get == -2)
                assert(Exercises.max3(Seq(900)).get == 900)
                assert(Exercises.max3(Seq()).isEmpty)
            }
        }

        'test_sum - {
            'first_realization - {
                assert(Exercises.sum1(1, 2) == 3)
                assert(Exercises.sum1(0, 0) == 0)
                assert(Exercises.sum1(1, -1) == 0)
                assert(Exercises.sum1(12, 8) == 20)
                assert(Exercises.sum1(-6, -7) == -13)
            }
            'second_realization - {
                assert(Exercises.sum2(1, 2) == 3)
                assert(Exercises.sum2(0, 0) == 0)
                assert(Exercises.sum2(1, -1) == 0)
                assert(Exercises.sum2(12, 8) == 20)
                assert(Exercises.sum2(-6, -7) == -13)
            }
            'third_realization - {
                assert(Exercises.sum3(1, 2) == 3)
                assert(Exercises.sum3(0, 0) == 0)
                assert(Exercises.sum3(1, -1) == 0)
                assert(Exercises.sum3(12, 8) == 20)
                assert(Exercises.sum3(-6, -7) == -13)
            }
        }
    }
}
