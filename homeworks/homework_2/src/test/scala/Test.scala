import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumDivBy3or5 - {
            assert(Exercises.sumOfDivBy3Or5(0, 0) == 0)
            assert(Exercises.sumOfDivBy3Or5(0, 4) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 4) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 5) == 8)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(0) == Seq())
            assert(Exercises.primeFactor(1) == Seq())
            assert(Exercises.primeFactor(13) == Seq(13))
            assert(Exercises.primeFactor(60) == Seq(2, 3, 5))
        }
        'test_sumByFunc - {
            assert(
                Exercises.sumScalars(Vector2D(2, 4), Vector2D(5, 2), Vector2D(8, 3), Vector2D(6, 5)) == 81.toDouble
            )
            assert(
                Math.abs(Exercises.sumCosines(Vector2D(2, 4), Vector2D(5, 2), Vector2D(8, 3), Vector2D(6, 5)) - 0.75 - 0.944) < 0.01
            )
            assert(
                Exercises.sumCosines(
                    Vector2D(3, 4), Vector2D(1, 3), Vector2D(4, 1), Vector2D(2, 6)
                ) == Exercises.cosBetween(
                    Vector2D(3, 4), Vector2D(1, 3)) + Exercises.cosBetween(Vector2D(4, 1), Vector2D(2, 6)
                )
            )
        }
        'test_sortByHeavyweight - {
            assert(
                Exercises.sortByHeavyweight() == Seq(
                    "Tin",      "Platinum", "Nickel",
                    "Aluminum", "Titanium", "Lead",
                    "Sodium",   "Uranium",  "Gold",
                    "Tungsten", "Zirconium","Chrome",
                    "Iron",     "Copper",   "Silver",
                    "Plutonium","Cobalt",   "Cesium",
                    "Calcium",  "Lithium",  "Magnesium",
                    "Potassium","Graphite"
                )
            )
        }
    }
}
