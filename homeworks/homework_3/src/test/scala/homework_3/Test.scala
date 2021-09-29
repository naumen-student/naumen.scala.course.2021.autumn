package homework_3

import utest._

object Test extends TestSuite{


    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'prettyBooleanFormatter1 - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            val numStr = "123"
            assert(Exercises.prettyBooleanFormatter1(123) == numStr)
        }

        'prettyBooleanFormatter2 - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            val numStr = "123"
            assert(Exercises.prettyBooleanFormatter2(123) == numStr)
        }
    }
}
