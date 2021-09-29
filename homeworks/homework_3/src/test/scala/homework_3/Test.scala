package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{


        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1("some string") == "some string")
            assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter1(List(1,2,3)) == List(1,2,3).toString())
        }

        'test_prettyBooleanFormatter2 - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2("правда, живите по правде") == "правда, живите по правде")
        }

        'test_prettyBooleanFormatter3 - {
            val testMap = Map("true" -> true, "false" -> false)
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(testMap) == testMap.toString())
        }

        'test_max1 - {
            val emptySeq = Seq()
            val notEmptySeq = Seq(1, 14, 42, 28)
            assert(Exercises.max1(notEmptySeq) == 42)
            assert(Exercises.max1(emptySeq) == emptySeq.hashCode())
        }

        'test_max2 - {
            val emptySeq = Seq()
            val notEmptySeq = Seq(1, 14, 42, 28)
            assert(Exercises.max2(notEmptySeq) == Seq(42))
            assert((Exercises.max2(emptySeq) == Seq()))
        }

        'test_max3 - {
            val emptySeq = Seq()
            val notEmptySeq = Seq(1, 14, 42, 28)
            assert(Exercises.max3(notEmptySeq) == Some(42))
            assert(Exercises.max3(emptySeq) == None)
        }

        'test_sums - {
            assert(Exercises.sum1(20, 22) == 42)
            assert(Exercises.sum2(12, 34) == 46)
            assert(Exercises.sum3(45, 55) == 100)
        }
    }
}

