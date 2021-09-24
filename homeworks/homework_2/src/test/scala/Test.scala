import Exercises.Vector2D
import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 10) == 33)
            assert(Exercises.sumOfDivBy3Or5(0, 1) ==  0)
            assert(Exercises.sumOfDivBy3Or5(0, 16) ==  60)
        }

        'primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(5) == Seq(5))
            assert(Exercises.primeFactor(100) == Seq(2, 5))
            assert(Exercises.primeFactor(17) == Seq(17))
        }

        'sumScalars - {
            assert(Exercises.sumScalars(Vector2D(2.0, 1.0), Vector2D(3.0, 1.0), Vector2D(5.0, 1.0), Vector2D(6.0, 1.0)) == 38.0)
            assert(Exercises.sumScalars(Vector2D(1.0, 1.0), Vector2D(1.0, 1.0), Vector2D(1.0, 1.0), Vector2D(1.0, 1.0)) == 4.0)
            assert(Exercises.sumScalars(Vector2D(7.5, 1.4), Vector2D(1.7, 4.5), Vector2D(5.89, 1.1), Vector2D(6.1, 1.54)) == 56.673)
            assert(Exercises.sumScalars(Vector2D(0.1, 0.76), Vector2D(0.015, 1.0), Vector2D(8.5, 4.1), Vector2D(10.5, 3.7)) == 105.1815)
        }

        'sumCosines - {
            assert(Exercises.sumCosines(Vector2D(3.0, 4.0), Vector2D(4.0, 3.0), Vector2D(4.0, 3.0), Vector2D(3.0, 4.0)) == 1.92)
            assert(Exercises.sumCosines(Vector2D(1.0, 4.0), Vector2D(5.0, 8.0), Vector2D(1.0, 4.0), Vector2D(5.0, 8.0)) == 1.902445637897525)
            assert(Exercises.sumCosines(Vector2D(4.3, 6.05), Vector2D(2.2, 8.0), Vector2D(5.5, 7.0), Vector2D(1.01, 100.0)) == 1.7320503083866151)
            assert(Exercises.sumCosines(Vector2D(1.0, 1.0), Vector2D(1.0, 1.0), Vector2D(4.0, 3.0), Vector2D(3.0, 4.0)) == 1.96)
        }

        'sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map(
                "Aluminum" -> (3, 2.6889), "Magnesium" -> (10, 1.738), "Chrome" -> (3, 7.18))) == Seq("Aluminum", "Chrome", "Magnesium"))
            assert(Exercises.sortByHeavyweight(Map(
                "Aluminum" ->  (3, 2.6889),  "Silver" -> (4,   4.505), "Magnesium" -> (10, 1.738),
                "Plutonium" -> (3,   19.25), "Chrome" -> (3, 7.18),    "Cesium" -> (7,   1.873),
                "Titanium" ->  (2,   10.50), "Iron" -> (3,   7.874),   "Tin" -> (1,   7.29))) == Seq("Tin", "Aluminum", "Titanium", "Chrome", "Iron", "Silver", "Plutonium", "Cesium", "Magnesium"))
            assert(Exercises.sortByHeavyweight(Map("Magnesium" -> (10, 1.738), "Tin" -> (1,   7.29))) == Seq("Tin", "Magnesium"))
            assert(Exercises.sortByHeavyweight(Map("Tin" -> (1,   7.29))) == Seq("Tin"))
        }


    }
}
