import Exercises.Vector2D
import utest._

object Test extends TestSuite {

  val tests = Tests {
    'test_divBy3Or7 - {
      assert(Exercises.divBy3Or7(1, 3) == Seq(3))
      assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
      assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30,
        33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91,
        93, 96, 98, 99))
    }

    'test_sumOfDivBy3Or5 - {
      assert(Exercises.sumOfDivBy3Or5(0, 3) == 3)
      assert(Exercises.sumOfDivBy3Or5(4, 10) == 30)
      assert(Exercises.sumOfDivBy3Or5(0, 100) == 2418)
    }

    'test_primeFactor - {
      assert(Exercises.primeFactor(80) == Seq(2, 5))
      assert(Exercises.primeFactor(98) == Seq(2, 7))
      assert(Exercises.primeFactor(1) == Seq())
    }

    'test_sumByFunc - {
      assert(Exercises.sumCosines(Vector2D(0, 1), Vector2D(1, 2), Vector2D(0, 1), Vector2D(1, 2)) ==
        2 * Exercises.cosBetween(Vector2D(0, 1), Vector2D(1, 2)))
      assert(Exercises.sumScalars(Vector2D(0, 1), Vector2D(1, 2), Vector2D(0, 1), Vector2D(1, 2)) ==
        2 * Exercises.scalar(Vector2D(0, 1), Vector2D(1, 2)))
      assert(Exercises.sumCosines(Vector2D(2, 12), Vector2D(6, 8), Vector2D(7, 15), Vector2D(1, 2)) ==
        Exercises.cosBetween(Vector2D(2, 12), Vector2D(6, 8)) +
          Exercises.cosBetween(Vector2D(7, 15), Vector2D(1, 2)))
      assert(Exercises.sumScalars(Vector2D(2, 12), Vector2D(6, 8), Vector2D(7, 15), Vector2D(1, 2)) ==
        Exercises.scalar(Vector2D(2, 12), Vector2D(6, 8)) +
          Exercises.scalar(Vector2D(7, 15), Vector2D(1, 2)))
    }

    'test_sortByHeavyweight - {
      assert(Exercises.sortByHeavyweight() == Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead",
        "Sodium", "Uranium", "Gold", "Tungsten", "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium",
        "Cobalt", "Cesium", "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"))
      val balls2: Map[String, (Int, Double)] = Map("Aluminum" -> (1, 2.6889),
          "Gold" -> (1, 19.32), "Lithium" ->  (1,  0.534))
        assert(Exercises.sortByHeavyweight(balls2) == Seq("Lithium", "Aluminum", "Gold"))

        val balls3: Map[String, (Int, Double)] = Map("A" -> (1, 2.5), "B" -> (2, 2.5), "C" -> (3, 2.5))
        assert(Exercises.sortByHeavyweight(balls3) == Seq("A", "B", "C"))
    }
  }
}
