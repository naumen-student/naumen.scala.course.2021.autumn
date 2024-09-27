import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 4) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 8) == 14)
            assert(Exercises.sumOfDivBy3Or5(4, 11) == 30)
            assert(Exercises.sumOfDivBy3Or5(13, 14) == 0)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(1) == Seq())
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(97) == Seq(97))
        }

        'test_sumScalars - {
            assert(Exercises.sumScalars(Exercises.Vector2D(1, -1), Exercises.Vector2D(1, 1), Exercises.Vector2D(1, 1), Exercises.Vector2D(-1, -1)) == -2)
            assert(Exercises.sumScalars(Exercises.Vector2D(1, -1), Exercises.Vector2D(1, 1), Exercises.Vector2D(1, -1), Exercises.Vector2D(1, 1)) == 0)
            assert(Exercises.sumScalars(Exercises.Vector2D(1, 1), Exercises.Vector2D(1, 1), Exercises.Vector2D(1, -1), Exercises.Vector2D(1, 1)) == 2)
            assert(Exercises.sumScalars(Exercises.Vector2D(2, 3), Exercises.Vector2D(4, 5), Exercises.Vector2D(6, 7), Exercises.Vector2D(8, 9)) == 134)
        }

        'test_sumCosines - {
            assert(Exercises.sumCosines(Exercises.Vector2D(1, -1), Exercises.Vector2D(1, 1), Exercises.Vector2D(1, 1), Exercises.Vector2D(-1, -1)) + 1 < 0.0001)
            assert(Exercises.sumScalars(Exercises.Vector2D(1, -1), Exercises.Vector2D(1, 1), Exercises.Vector2D(1, -1), Exercises.Vector2D(1, 1)) == 0)
            assert(Exercises.sumScalars(Exercises.Vector2D(1, 1), Exercises.Vector2D(1, 1), Exercises.Vector2D(1, -1), Exercises.Vector2D(1, 1)) == 2)
        }

        'test_sortByHeavyweight - {
            val balls: Map[String, (Int, Double)] =
                Map(
                    "Aluminum" -> (3,   2.6889), "Tungsten" ->  (2,   19.35)
                )
            assert(Exercises.sortByHeavyweight(balls) == Seq("Aluminum", "Tungsten"))
            val balls1: Map[String, (Int, Double)] =
                Map(
                    "Tungsten" ->  (2,   19.35), "Aluminum" -> (3,   2.6889)
                )
            assert(Exercises.sortByHeavyweight(balls1) == Seq("Aluminum", "Tungsten"))
            val balls2: Map[String, (Int, Double)] =
                Map(
                    "A" ->  (2,   1), "B" -> (1,   9),
                    "C" ->  (3,   1), "D" -> (1,   7)
                )
            assert(Exercises.sortByHeavyweight(balls2) == Seq("D", "A", "B", "C"))
        }
    }
}
