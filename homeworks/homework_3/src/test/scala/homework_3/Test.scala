package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'prettyBooleanFormatter1_boolTrueParam - {
            val expected = "правда"

            val actual = Exercises.prettyBooleanFormatter1(true)

            assert(actual == expected)
        }
        'prettyBooleanFormatter1_intParam - {
            val expected = "10"

            val actual = Exercises.prettyBooleanFormatter1(10)

            assert(actual == expected)
        }
        'prettyBooleanFormatter1_boolFalseParam - {
            val expected = "ложь"

            val actual = Exercises.prettyBooleanFormatter1(false)

            assert(actual == expected)
        }

        'prettyBooleanFormatter2_boolTrueParam - {
            val expected = "правда"

            val actual = Exercises.prettyBooleanFormatter2(true)

            assert(actual == expected)
        }
        'prettyBooleanFormatter2_intParam - {
            val expected = "10"

            val actual = Exercises.prettyBooleanFormatter2(10)

            assert(actual == expected)
        }
        'prettyBooleanFormatter2_boolFalseParam - {
            val expected = "ложь"

            val actual = Exercises.prettyBooleanFormatter2(false)

            assert(actual == expected)
        }

        'prettyBooleanFormatter3_boolTrueParam - {
            val expected = "правда"

            val actual = Exercises.prettyBooleanFormatter3(true)

            assert(actual == expected)
        }
        'prettyBooleanFormatter3_intParam - {
            val expected = "10"

            val actual = Exercises.prettyBooleanFormatter3(10)

            assert(actual == expected)
        }
        'prettyBooleanFormatter3_boolFalseParam - {
            val expected = "ложь"

            val actual = Exercises.prettyBooleanFormatter3(false)

            assert(actual == expected)
        }

        'max1_emptySeq_throwsError - {
            val thrown = intercept[IllegalArgumentException] {
                Exercises.max1(Seq())
            }
            assert(thrown.getMessage == "Collection is empty")
        }
        'max1_notEmptySeq_returnsMax - {
            val expected = 10

            val actual = Exercises.max1(Seq(1, 2, 10))

            assert(actual == expected)
        }
        'max1_oneElementSeq_returnsElement - {
            val expected = 10

            val actual = Exercises.max1(Seq(10))

            assert(actual == expected)
        }

        'max2_emptySeq_returnsEmptySeq - {
            val actual = Exercises.max2(Seq())

            assert(actual.length == 0)
        }
        'max2_notEmptySeq_returnsMax - {
            val expected = List(10)

            val actual = Exercises.max2(Seq(1, 2, 10))

            assert(actual == expected)
        }
        'max2_oneElementSeq_returnsElement - {
            val expected = List(10)

            val actual = Exercises.max2(Seq(10))

            assert(actual == expected)
        }

        'max3_emptySeq_returnsNone - {
            val actual = Exercises.max3(Seq())

            assert(actual == None)
        }
        'max3_notEmptySeq_returnsMax - {
            val expected = Some(10)

            val actual = Exercises.max3(Seq(1, 2, 10))

            assert(actual == expected)
        }
        'max3_oneElementSeq_returnsElement - {
            val expected = Some(10)

            val actual = Exercises.max3(Seq(10))

            assert(actual == expected)
        }

        'sum1_test1 - {
            val expected = 10

            val actual = Exercises.sum1(5, 5)

            assert(actual == expected)
        }
        'sum1_test2 - {
            val expected = 15

            val actual = Exercises.sum1(7, 8)

            assert(actual == expected)
        }
        'sum1_test3 - {
            val expected = 3

            val actual = Exercises.sum1(1, 2)

            assert(actual == expected)
        }

        'sum2_test1 - {
            val expected = 10

            val actual = Exercises.sum2(5, 5)

            assert(actual == expected)
        }
        'sum2_test2 - {
            val expected = 15

            val actual = Exercises.sum2(7, 8)

            assert(actual == expected)
        }
        'sum2_test3 - {
            val expected = 3

            val actual = Exercises.sum2(1, 2)

            assert(actual == expected)
        }

        'sum3_test1 - {
            val expected = 10

            val actual = Exercises.sum3(5, 5)

            assert(actual == expected)
        }
        'sum3_test2 - {
            val expected = 15

            val actual = Exercises.sum3(7, 8)

            assert(actual == expected)
        }
        'sum3_test3 - {
            val expected = 3

            val actual = Exercises.sum3(1, 2)

            assert(actual == expected)
        }
    }
}
