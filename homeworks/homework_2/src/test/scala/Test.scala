import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(5, 9) == 20)
            assert(Exercises.sumOfDivBy3Or5(0, 100) == 2418)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(51870) == Seq(2, 3, 5, 7, 13, 19))
        }
        'test_sumScalars - {

        }
        'sortByHeavyweight - {
            val forFirstTest: Map[String, (Int, Double)] =
                Map(
                    "light" -> (1, 0.5), "medium" -> (1, 2), "heavy" -> (1, 3)
                )
            val forSecondTest: Map[String, (Int, Double)] =
                Map(
                    "heavy" -> (1, 3), "medium" -> (1, 2), "light" -> (1, 0.5)
                )
            val forThirdTest: Map[String, (Int, Double)] =
                Map(
                    "medium1" -> (4, 0.5),  "heavy" -> (1, 3), "medium2" -> (1, 2)
                )
            val forFourthTest: Map[String, (Int, Double)] =
                Map(
                    "medium1" -> (4, 0.5), "medium3" -> (1, 2), "medium2" -> (1, 2)
                )
            assert(Exercises.sortByHeavyweight(forFirstTest) == Seq("light", "medium", "heavy"))
            assert(Exercises.sortByHeavyweight(forSecondTest) == Seq("light", "medium", "heavy"))
            assert(Exercises.sortByHeavyweight(forThirdTest) == Seq("medium1", "medium2", "heavy"))
            assert(Exercises.sortByHeavyweight(forFourthTest) == Seq("medium1", "medium3", "medium2"))
        }
    }
}
