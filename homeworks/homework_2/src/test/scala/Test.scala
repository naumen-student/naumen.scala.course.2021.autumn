import Exercises.Vector2D
import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(5, 9) == 20)
            assert(Exercises.sumOfDivBy3Or5(0, 100) == 2418)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(105) == Seq(3, 5, 7))
            assert(Exercises.primeFactor(320) == Seq(2, 5))
        }

        'test_sumByFunc - {
            assert(Exercises.sumScalars(Vector2D(2, 4), Vector2D(5, 2), Vector2D(8, 3), Vector2D(6, 5)) == (18 + 63).toDouble)
            assert(Exercises.sumScalars(Vector2D(7, 13), Vector2D(6, 10), Vector2D(9, 20), Vector2D(15, 21)) == (172 + 555).toDouble)
            assert(Math.abs(Exercises.sumCosines(Vector2D(2, 4), Vector2D(5, 2), Vector2D(8, 3), Vector2D(6, 5)) - 0.75 - 0.944) < 0.01)
            assert(Math.abs(Exercises.sumCosines(Vector2D(7, 13), Vector2D(6, 10), Vector2D(9, 20), Vector2D(15, 21)) - 0.9989 - 0.98) < 0.01)
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight() == Seq("Tin",
                "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten",
                "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium",
                "Lithium", "Magnesium", "Potassium", "Graphite"))
        }
    }
}