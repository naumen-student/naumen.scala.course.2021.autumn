package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_firstTask - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(1726) == "1726")
            assert(Exercises.prettyBooleanFormatter1("string") == "string")
            assert(Exercises.prettyBooleanFormatter1(Boolean) == "object scala.Boolean")
            assert(Exercises.prettyBooleanFormatter1(Int) == "object scala.Int")

            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(1726) == "1726")
            assert(Exercises.prettyBooleanFormatter1("yum yum") == "yum yum")
            assert(Exercises.prettyBooleanFormatter1(Boolean) == "object scala.Boolean")
            assert(Exercises.prettyBooleanFormatter1(Int) == "object scala.Int")

            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(1726) == "1726")
            assert(Exercises.prettyBooleanFormatter1("string") == "string")
            assert(Exercises.prettyBooleanFormatter1(Boolean) == "object scala.Boolean")
            assert(Exercises.prettyBooleanFormatter1(Int) == "object scala.Int")
        }
        'test_secondTask - {
            val Seq1 = Seq(1, 2, 5, 6, 3)
            val Seq2 = Seq(-4, -3, -543, -6)
            val Seq3 = Seq()
            assert(Exercises.max1(Seq1) == 6)
            assert(Exercises.max1(Seq2) == -3)
            assert(Exercises.max1(Seq3) == Int.MinValue)

            assert(Exercises.max2(Seq1) == Seq(6))
            assert(Exercises.max2(Seq2) == Seq(-3))
            assert(Exercises.max2(Seq3) == Seq())

            assert(Exercises.max3(Seq1).contains(6))
            assert(Exercises.max3(Seq2).contains(-3))
            assert(Exercises.max3(Seq3).isEmpty)
        }
        'test_thirdTask - {
            assert(Exercises.sum1(3, 2) == 5)
            assert(Exercises.sum1(0, 0) == 0)
            assert(Exercises.sum1(5, -3) == 2)

            assert(Exercises.sum2(3, 2) == 5)
            assert(Exercises.sum2(0, 0) == 0)
            assert(Exercises.sum2(5, -3) == 2)

            assert(Exercises.sum3(3, 2) == 5)
            assert(Exercises.sum3(0, 0) == 0)
            assert(Exercises.sum3(5, -3) == 2)
        }
    }
}
