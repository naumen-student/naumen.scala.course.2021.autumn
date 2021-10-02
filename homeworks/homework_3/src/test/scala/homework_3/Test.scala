package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_prettyBooleanFormatter1 {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(2l) == "2")
            assert(Exercises.prettyBooleanFormatter1(()) == "()")
        }

        'test_prettyBooleanFormatter2 {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(2l) == "2")
            assert(Exercises.prettyBooleanFormatter2(()) == "()")
        }

        'test_prettyBooleanFormatter3 {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3(2l) == "2")
            assert(Exercises.prettyBooleanFormatter3(()) == "()")
        }

        'test_max1{
            assert(Exercises.max1(Seq()) == -1)
            assert(Exercises.max1(Seq(1,2,3)) == 3)
            assert(Exercises.max1(Seq(1)) == 1)
        }

        'test_max2{
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(1,2,3)) == Seq(3))
            assert(Exercises.max2(Seq(1)) == Seq(1))
        }

        'test_max3{
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max3(Seq(1,2,3)) == Some(3))
            assert(Exercises.max3(Seq(1)) == Some(1))
        }

        'test_sum1{
            assert(Exercises.sum1(0,0) == 0)
            assert(Exercises.sum1(1,1) == 2)
            assert(Exercises.sum1(0,1) == 1)
        }


        'test_max3{
            assert(Exercises.sum2(0,0) == 0)
            assert(Exercises.sum2(1,1) == 2)
            assert(Exercises.sum2(0,1) == 1)
        }


        'test_max3{
            assert(Exercises.sum3(0,0) == 0)
            assert(Exercises.sum3(1,1) == 2)
            assert(Exercises.sum3(0,1) == 1)
        }
    }
}
