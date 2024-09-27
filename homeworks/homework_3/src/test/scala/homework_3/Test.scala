package homework_3

import homework_3.Exercises.{prettyBooleanFormatter1, prettyBooleanFormatter2, prettyBooleanFormatter3}
import utest._

object Test extends TestSuite{
    class A
    case class B() // внутри def впихнуть не получается, падает

    val tests = Tests{
        'test_prettyBooleanFormatter - {

            def testPrettyBooleanFormatterFunc(prettyBooleanFormatter: Any => String) {
                val trueStr = "правда"
                val falseStr = "ложь"

                assert(prettyBooleanFormatter(true) == trueStr)
                assert(prettyBooleanFormatter(false) == falseStr)

                Seq(
                    0, 1, 0.0, 1.0, 5, 5.5, -1, -5,
                    0d, 2.003d, -8d, Int.MaxValue, Double.MinValue, 78L, -200L, Long.MaxValue, Short.MinValue,
                    't', '5', 'я', '\n',
                    "", "a", "abc", "правда", "ложь",
                    Unit, List(7, 8), new A, B()
                )
                  .foreach(x => assert(prettyBooleanFormatter(x) == x.toString))
            }

            testPrettyBooleanFormatterFunc(prettyBooleanFormatter1)
            testPrettyBooleanFormatterFunc(prettyBooleanFormatter2)
            testPrettyBooleanFormatterFunc(prettyBooleanFormatter3)
        }

        'test_max - {
            def testMaxFunc[TRes](max: Seq[Int] => TRes, getRes: Int => TRes, emptyRes: TRes): Unit = {
                assert(max(Seq()) == emptyRes)

                assert(max(Seq(0)) == getRes(0))
                assert(max(Seq(7)) == getRes(7))
                assert(max(Seq(-8)) == getRes(-8))
                assert(max(Seq(Int.MaxValue)) == getRes(Int.MaxValue))
                assert(max(Seq(Int.MinValue)) == getRes(Int.MinValue))

                assert(max(Seq(0, 0)) == getRes(0))
                assert(max(Seq(0, 1)) == getRes(1))
                assert(max(Seq(4, Int.MaxValue, 2)) == getRes(Int.MaxValue))
                assert(max(Seq(4, Int.MinValue, 2)) == getRes(4))
                assert(max(Seq(0, 1, 2)) == getRes(2))
                assert(max(Seq(0, 2, 1)) == getRes(2))

                assert(max(Seq(-1, -2, -3)) == getRes(-1))
                assert(max(Seq(-2, -3, -8, -1)) == getRes(-1))
                assert(max(Seq(-3, 0, 3)) == getRes(3))
                assert(max(Seq(-10, -15, 15, 0)) == getRes(15))
                assert(max(Seq(-5, Int.MinValue)) == getRes(-5))
                assert(max(Seq(-5, Int.MaxValue)) == getRes(Int.MaxValue))

                assert(max(Seq(0, 1, 2, 3, 2, 0, 4, 5)) == getRes(5))
                assert(max(Seq(7, 6, 4961, 1368574, -46154, 516545, 16587486, -46558484)) == getRes(16587486))
            }

            testMaxFunc(Exercises.max1, identity, Int.MinValue)
            testMaxFunc(Exercises.max2, Seq(_), Seq())
            testMaxFunc(Exercises.max3, Some(_), None)
        }

        'test_sum - {
            def testSumFunc(sum: (Int, Int) => Int): Unit = {
                val termsAndResults = List(
                    (0, 0, 0),
                    (0, 1, 1),
                    (1, 0, 1),
                    (1, 1, 2),
                    (-1, 0, -1),
                    (0, -1, -1),
                    (-1, 1, 0),
                    (1, -1, 0),
                    (1, 3, 4),
                    (5, 6, 11),
                    (7, 4, 11),
                    (8, 9, 17),
                    (-2, 6, 4),
                    (9, -3, 6),
                    (-8, -2, -10),
                    (0, -7, -7),
                    (-3, 3, 0),
                    (Int.MinValue, 8, Int.MinValue + 8),
                    (-3, Int.MaxValue, Int.MaxValue - 3),
                    (Int.MaxValue, Int.MinValue, -1)
                )

                for ((term1, term2, expected) <- termsAndResults) {
                    assert(sum(term1, term2) == expected)
                }
            }

            testSumFunc(Exercises.sum1)
            testSumFunc(Exercises.sum2)
            testSumFunc(Exercises.sum3)
        }
    }
}
