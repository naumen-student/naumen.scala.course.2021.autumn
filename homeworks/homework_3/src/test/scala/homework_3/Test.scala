package homework_3

import utest._

object Test extends TestSuite{



    val tests = Tests {

        "BooleanFormatter-1" - {
                assert(Exercises.prettyBooleanFormatter1(true) == "правда")
                assert(Exercises.prettyBooleanFormatter1("StrForTest") == "StrForTest")
                assert(Exercises.prettyBooleanFormatter1(false) == "ложь")
                assert(Exercises.prettyBooleanFormatter1(100500) == "100500")
        }

        "BooleanFormatter-2" - {
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter2(List(1, 0, 4)) == "List(1, 0, 4)")
            assert(Exercises.prettyBooleanFormatter2("AnotherStr") == "AnotherStr")
            assert(Exercises.prettyBooleanFormatter2(Tuple1(12, 13)) == "((12,13))")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
        }

        "BooleanFormatter-3" - {
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter3(345124.432) == "345124.432")
            assert(Exercises.prettyBooleanFormatter3("yetAnother") == "yetAnother")
            assert(Exercises.prettyBooleanFormatter2(Seq(2, 5, 7, 15)) == "List(2, 5, 7, 15)")
        }

        "Maximum-1" - {
            assert(Exercises.max1(Seq()) == Int.MinValue)
            assert(Exercises.max1((Seq(1, 9, 3, 5))) == 9)
            assert(Exercises.max1(Seq(-1, 0)) == 0)
            assert(Exercises.max1(List(-100, -35)) == -35)
        }

        "Maximum-2" - {
            assert(Exercises.max2(Seq(-41, 31, 0)) == Seq(31))
            assert(Exercises.max2(Seq(2940, 2939)) == Seq(2940))
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max2(Seq(10, 11, Int.MaxValue)) == Seq(Int.MaxValue))
        }

        "Maximum-3" - {
            assert(Exercises.max3(Seq()) == None)
            assert(Exercises.max3(Seq(412, 420, 313)) == Some(420))
            assert(Exercises.max3((Seq(2))) == Some(2))
            assert(Exercises.max3(Seq(+0, -0)) == Some(0))
        }

        "TestSum-1" - {
            assert(Exercises.sum1(10, 11) == 21)
            assert(Exercises.sum1(-152, 0) == -152)
            assert(Exercises.sum1(-40, 40) == 0)
            assert(Exercises.sum1(100, 20) == 120)
        }

        "TestSum-2" - {
            assert(Exercises.sum2(255, 1) == 256)
            assert(Exercises.sum2(-1, 1) == 0)
            assert(Exercises.sum2(30, 20) == 50)
            assert(Exercises.sum2(320, 200) == 520)
        }

        "TestSum-3" - {
            assert(Exercises.sum2(140, 11) == 151)
            assert(Exercises.sum2(2, 10) == 12)
            assert(Exercises.sum2(82, 80) == 162)
            assert(Exercises.sum2(-20, -40) == -60)
        }
    }
}
