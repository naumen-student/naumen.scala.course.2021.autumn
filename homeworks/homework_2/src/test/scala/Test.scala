import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1,1) == 0)
            assert(Exercises.sumOfDivBy3Or5(1,5) == 8)
            assert(Exercises.sumOfDivBy3Or5(15,30) == List(15,20,25,30,18,21,24,27).sum)
            assert(Exercises.sumOfDivBy3Or5(1,3) == 3)
        }

        'primeFactor - {
            assert(Exercises.primeFactor( 1) == Seq())
            assert(Exercises.primeFactor(5) == Seq(5))
            assert(Exercises.primeFactor(15) == Seq(3,5))
            assert(Exercises.primeFactor(30) == Seq(2,3,5))
            assert(Exercises.primeFactor(80) == Seq(2,5))
            assert(Exercises.primeFactor(98) == Seq(2,7))
            assert(Exercises.primeFactor(90) == Seq(2,3,5))
        }

        'heavyBalls - {
            val balls1 = Map(
                "3" -> (3, 2.5),
                "1" -> (1, 2.5),
                "2" -> (2, 2.5)
            )
            val balls2 = Map(
                "3" -> (1, 10.0),
                "1" -> (1, 1.0),
                "2" -> (1, 5.0)
            )
            val balls3 = Map(
                "2" -> (3, 1.0),
                "1" -> (1, 10.0),
                "3" -> (2, 5.0)
            )
            assert(Exercises.sortByHeavyweight(balls1) == Seq("1", "2", "3"))
            assert(Exercises.sortByHeavyweight(balls2) == Seq("1", "2", "3"))
            assert(Exercises.sortByHeavyweight(balls3) == Seq("2", "1", "3"))
        }
    }
}
