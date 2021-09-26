package homework_3

import utest._

import scala.util.Try

object Test extends TestSuite {

    val tests: Tests = Tests {
        'test_prettyBooleanFormatter - {
            val trueStr = "правда"
            val falseStr = "ложь"

            for {
                method <- Seq[Any => String](
                    Exercises.prettyBooleanFormatter1,
                    Exercises.prettyBooleanFormatter2,
                    Exercises.prettyBooleanFormatter3
                )
            } {
                assert(method(true) == trueStr)
                assert(method(false) == falseStr)
                assert(method(1) == "1")
                assert(method(List(2)) == "List(2)")
            }
        }

        'test_max - {
            'test_max1 - {
                assert(Try(Exercises.max1(Nil)).isFailure)
                assert(Exercises.max1(Seq(1, 2, 3)) == 3)
                assert(Exercises.max1(Seq(-1, -2, -3)) == -1)
            }

            'test_max2 - {
                assert(Exercises.max2(Nil) == Nil)
                assert(Exercises.max2(Seq(1, 2, 3, 3)) == Seq(3))
                assert(Exercises.max2(Seq(-1, -2, -3)) == Seq(-1))
            }

            'test_max3 - {
                assert(Exercises.max3(Nil).isEmpty)
                assert(Exercises.max3(Seq(1, 2, 3)).contains(3))
                assert(Exercises.max3(Seq(-1, -2, -3)).contains(-1))
            }
        }

        'test_sum - {
            for {
                method <- Seq[(Int, Int) => Int](
                    Exercises.sum1,
                    Exercises.sum2,
                    Exercises.sum3
                )
            } {
                assert(method(0, 0) == 0)
                assert(method(0, 1) == 1)
                assert(method(-1, 1) == 0)
                assert(method(10, 10) == 20)
            }
        }
    }
}
