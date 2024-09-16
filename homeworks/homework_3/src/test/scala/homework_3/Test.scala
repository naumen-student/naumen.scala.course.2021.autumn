package homework_3

import homework_3.Exercises.{prettyBooleanFormatter1, prettyBooleanFormatter2}
import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(Seq()) == Seq().toString())
            assert(Exercises.prettyBooleanFormatter1(1) == "1")
            assert(Exercises.prettyBooleanFormatter1(2.2) == "2.2")
            assert(Exercises.prettyBooleanFormatter1(Exercises) == Exercises.toString)
        }

        'test_prettyBooleanFormatter2 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(Seq()) == Seq().toString())
            assert(Exercises.prettyBooleanFormatter2(1) == "1")
            assert(Exercises.prettyBooleanFormatter2(2.2) == "2.2")
            assert(Exercises.prettyBooleanFormatter2(Exercises) == Exercises.toString)
        }

        'test_prettyBooleanFormatter3 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(Seq()) == Seq().toString())
            assert(Exercises.prettyBooleanFormatter3(1) == "1")
            assert(Exercises.prettyBooleanFormatter3(2.2) == "2.2")
            assert(Exercises.prettyBooleanFormatter3(Exercises) == Exercises.toString)
        }

        'test_maxes - {
            val testCases = List(
                Seq(1, 2, 3, 4),
                Seq (-1, -2, 4),
                Seq(3, -8),
                Seq(),
                Seq(15, Int.MaxValue)
            )
            val results1 = List(4, 4, 3, Int.MinValue, Int.MaxValue)
            val results2 = List(Seq(4), Seq(4), Seq(3), Seq(), Seq(Int.MaxValue))
            val results3 = List(Some(4), Some(4), Some(3), None, Some(Int.MaxValue))

            for (i <- 0 to 4) {
                val x1 = Exercises.max1(testCases(i))
                val x2 = Exercises.max2(testCases(i))
                val x3 = Exercises.max3(testCases(i))
                val res1 = results1(i)
                val res2 = results2(i)
                val res3 = results3(i)
                assert(x1 == res1)
                assert(x2 == res2)
                assert(x3 == res3)
            }
        }


        'test_sum - {
            val testCases = List(
                (1, 2),
                (-5, 7),
                (0, 0),
                (15, 17),
                (25, 78),
                (-200, 67),
                (85, 17)
            )

            val results = List(3, 2, 0, 32, 103, -133, 102)

            for (i <- 0 to 6) {
                assert(Exercises.sum1(testCases(i)._1, testCases(i)._2) == results(i))
                assert(Exercises.sum2(testCases(i)._1, testCases(i)._2) == results(i))
                assert(Exercises.sum3(testCases(i)._1, testCases(i)._2) == results(i))
            }
        }
    }
}
