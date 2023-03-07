import Exercises.{Vector2D, balls}
import utest._

object Test extends TestSuite{

    val testBalls: Map[String, (Int, Double)] =
        Map("1" -> (10,   10), "2" ->  (30,   30), "3" ->  (20,  20))

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
        }
        'test_sumScalars - {
            assert((Exercises.sumScalars(Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 1), Vector2D(1, 1)) - 2).abs < 1e-7)
            assert((Exercises.sumScalars(Vector2D(-1, 0), Vector2D(1, 0), Vector2D(0, 1), Vector2D(0, -1)) + 2).abs < 1e-7)
            assert((Exercises.sumScalars(Vector2D(45, -12), Vector2D(10, 8), Vector2D(11, 0), Vector2D(90, -150)) - 1344).abs < 1e-7)
        }
        'test_sumCosines - {
            assert((Exercises.sumCosines(Vector2D(1, 0), Vector2D(0, 1), Vector2D(1, 1), Vector2D(1, 1)) - 1).abs < 1e-7)
            assert((Exercises.sumCosines(Vector2D(-1, 0), Vector2D(1, 0), Vector2D(0, 1), Vector2D(0, -1)) + 2).abs < 1e-7)
        }
        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(testBalls) == Seq("1", "3", "2"))
            assert(Exercises.sortByHeavyweight() == Seq("Sodium", "Lithium", "Tin", "Aluminum", "Potassium",
                "Calcium", "Cesium", "Magnesium", "Nickel", "Silver", "Zirconium",
                "Titanium", "Platinum", "Chrome", "Lead", "Iron", "Graphite",
                "Copper", "Cobalt", "Uranium", "Gold", "Tungsten", "Plutonium"))
        }
    }
}