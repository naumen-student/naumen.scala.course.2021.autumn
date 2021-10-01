import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(3, 5) == 8)
            assert(Exercises.sumOfDivBy3Or5(3, 9) == 23)
        }

        'primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(10) == Seq(2, 5))
        }

        'sumScalars - {
            assert(Exercises.sumScalars(Vector2D(2, 0), Vector2D(1, 1), Vector2D(2, 2), Vector2D(4, 1)) == 12)
            assert(Exercises.sumScalars(Vector2D(-1, 3), Vector2D(4, 3), Vector2D(1, 1), Vector2D(0, 1)) == 6)
            assert(Exercises.sumScalars(Vector2D(-1, -5), Vector2D(3, 1), Vector2D(-2, 2), Vector2D(4, 3)) == -10)
        }

        'sumCosines - {
            assert(Exercises.sumCosines(Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0), Vector2D(-1, 0)) == -1)
            assert(Exercises.sumScalars(Vector2D(0, -1), Vector2D(0, 1), Vector2D(1, 0), Vector2D(1, 0)) == 0)
            assert(Exercises.sumScalars(Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 0), Vector2D(1, 0)) == 1)
        }

        'sortByHeavyweight - {
            val balls1: Map[String, (Int, Double)] =
                Map(
                    "Aluminum" -> (3,   2.6889)
                )

            val  balls2: Map[String, (Int, Double)] =
                Map(
                    "Aluminum" -> (3,   2.6889), "Tungsten" ->  (2,   19.35), "Graphite" ->  (12,  2.1),   "Iron" ->      (3,   7.874)
                )

            val balls3: Map[String, (Int, Double)] =
                Map(
                    "Chrome" ->   (3,   7.18),   "Cesium" ->    (7,   1.873), "Zirconium" -> (3,   6.45)
                )

            assert(Exercises.sortByHeavyweight(balls1) == Seq("Aluminum"))
            assert(Exercises.sortByHeavyweight(balls2) == Seq("Aluminum", "Tungsten", "Iron", "Graphite"))
            assert(Exercises.sortByHeavyweight(balls3) == Seq("Zirconium", "Chrome", "Cesium"))
        }
    }
}
