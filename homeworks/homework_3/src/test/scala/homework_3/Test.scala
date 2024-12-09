package homework_3

import utest._

object Test extends TestSuite{
    val trueStr = "правда"
    val falseStr = "ложь"

    val testStr = "wow"

    val testCollection1 = List(-1, 2, 3)
    val testCollection2 = List(-1)
    val emptyCollection = List.empty[Int]

    val tests = Tests{
        'test_prettyBooleanFormatter1 - {
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(1) == 1.toString)
            assert(Exercises.prettyBooleanFormatter1(testStr) == testStr)
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(1) == 1.toString)
            assert(Exercises.prettyBooleanFormatter2(testStr) == testStr)
        }

        'test_prettyBooleanFormatter3 - {
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(1) == 1.toString)
            assert(Exercises.prettyBooleanFormatter3(testStr) == testStr)
        }

        'test_max1 - {
            intercept[UnsupportedOperationException](
                Exercises.max1(emptyCollection)
            )
            assert(Exercises.max1(testCollection1) == 3)
            assert(Exercises.max1(testCollection2) == -1)
        }

        'test_max2 - {
            assert(Exercises.max2(testCollection1) == List(3))
            assert(Exercises.max2(testCollection2) == List(-1))
            assert(Exercises.max2(emptyCollection) == Seq.empty[Int])
        }

        'test_max3 - {
            assert(Exercises.max3(testCollection1).contains(3))
            assert(Exercises.max3(testCollection2).contains(-1))
            assert(Exercises.max3(emptyCollection).isEmpty)
        }

        'test_sum1 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum1(-1, 1) == 0)
            assert(Exercises.sum1(0, 0) == 0)
        }

        'test_sum2 - {
            assert(Exercises.sum2(1, 2) == 3)
            assert(Exercises.sum2(-1, 1) == 0)
            assert(Exercises.sum2(0, 0) == 0)
        }

        'test_sum3 - {
            assert(Exercises.sum3(1, 2) == 3)
            assert(Exercises.sum3(-1, 1) == 0)
            assert(Exercises.sum3(0, 0) == 0)
        }
    }
}
