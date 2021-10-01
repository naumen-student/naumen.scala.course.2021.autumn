package homework_3

import utest._

import scala.util.Failure

object Test extends TestSuite{

    val tests: Tests = Tests{
        'test_example - {
            val trueStr = "правда"
            print("!!!!")
            print(Exercises.prettyBooleanFormatter1(true))
            print(trueStr)
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'prettyBooleanFormatter1_1 - {
            val trueStr = "-90"
            assert(Exercises.prettyBooleanFormatter1((10-100).toString) == trueStr)
        }
        'prettyBooleanFormatter1_2 - {
            val trueStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(false) == trueStr)
        }
        'prettyBooleanFormatter1_3 - {
            val trueStr = "96"
            assert(Exercises.prettyBooleanFormatter1(98-2) == trueStr)
        }
        'prettyBooleanFormatter2_1 - {
            val trueStr = "ложь"
            assert(Exercises.prettyBooleanFormatter2(false) == trueStr)
        }
        'prettyBooleanFormatter2_2 - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
        }
        'prettyBooleanFormatter2_3 - {
            val trueStr = "17"
            assert(Exercises.prettyBooleanFormatter2(17) == trueStr)
        }
        'prettyBooleanFormatter3_1 - {
            val trueStr = "ложь"
            assert(Exercises.prettyBooleanFormatter3(false) == trueStr)
        }
        'prettyBooleanFormatter3_2 - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
        }
        'prettyBooleanFormatter3_3 - {
            val trueStr = "agora"
            assert(Exercises.prettyBooleanFormatter3("agora") == trueStr)
        }
        'max1_1 - {
            assert(Exercises.max1(Seq()) == 0)
        }
        'max1_2 - {
            assert(Exercises.max1(Seq(1,12,3)) == 12)
        }
        'max1_3 - {
            assert(Exercises.max1(Seq(1,12,37)) == 37)
        }
        'max2_1 - {
            assert(Exercises.max2(Seq()) == Seq())
        }
        'max2_2 - {
            assert(Exercises.max2(Seq(1,15,19)) == Seq(19))
        }
        'max2_3 - {
            assert(Exercises.max2(Seq(1,67,-89)) == Seq(67))
        }
        'max3_1 - {
            assert(Exercises.max3(Seq()).isEmpty)
        }
        'max3_2 - {
            assert(Exercises.max3(Seq(1, 2, 3)).contains(3))
        }
        'max3_3 - {
            assert(Exercises.max3(Seq(5, 20, 19)).contains(20))
        }
        'sum1_1 - {
           assert(Exercises.sum1(1,17) == 18)
        }
        'sum1_2 - {
            assert(Exercises.sum1(0, -5) == -5)
        }
        'sum1_3 - {
            assert(Exercises.sum1(-80, 80) == 0)
        }
        'sum2_1 - {
            assert(Exercises.sum2(-4,36) == 32)
        }
        'sum2_2 - {
            assert(Exercises.sum2(95,-95) == 0)
        }
        'sum2_3 - {
            assert(Exercises.sum2(-1,16) == 15)
        }
        'sum3_1 - {
            assert(Exercises.sum3(4,9) == 13)
        }
        'sum3_2 - {
            assert(Exercises.sum3(6,-8) == -2)
        }
        'sum3_3 - {
            assert(Exercises.sum3(0,0) == 0)
        }
    }
}
