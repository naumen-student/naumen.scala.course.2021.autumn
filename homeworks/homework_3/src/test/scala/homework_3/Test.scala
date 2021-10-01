package homework_3

import utest._

object Test extends TestSuite{

    val tests: Tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'test_exercise_1 - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)

            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)

            assert(Exercises.prettyBooleanFormatter1("false") == "String")
            assert(Exercises.prettyBooleanFormatter2(1 : Int) == "Integer")
            assert(Exercises.prettyBooleanFormatter3(1.1) == "Double")
        }
        'test_exercise_2 - {
            val empty = Seq[Int]()
            val up = Seq(1,2)
            val down = Seq(3,2,1)
            assert(Exercises.max1(empty) == 0)
            assert(Exercises.max1(up) == 2)
            assert(Exercises.max1(down) == 3)

            assert(Exercises.max2(empty).size == 0)
            assert(Exercises.max2(up) == Seq(2))
            assert(Exercises.max2(down) == Seq(3))

            assert(Exercises.max3(empty) == None)
            assert(Exercises.max3(up) == Some(2))
            assert(Exercises.max3(down) == Some(3))
        }
        'test_exercise_3 - {
            assert(Exercises.sum1(1,2) == 3)
            assert(Exercises.sum1(2,1) == 3)
            assert(Exercises.sum1(1,1) == 2)

            assert(Exercises.sum2(1,2) == 3)
            assert(Exercises.sum2(2,1) == 3)
            assert(Exercises.sum2(1,1) == 2)

            assert(Exercises.sum3(1,2) == 3)
            assert(Exercises.sum3(2,1) == 3)
            assert(Exercises.sum3(1,1) == 2)
        }
    }
}
