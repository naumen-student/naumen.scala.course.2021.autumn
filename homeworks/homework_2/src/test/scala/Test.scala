import Exercises.Vector2D
import utest._

object Test extends TestSuite {

    val tests: Tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(
                    0, 3, 6, 7, 9, 12,
                    14, 15, 18, 21, 24,
                    27, 28, 30, 33, 35,
                    36, 39, 42, 45, 48,
                    49, 51, 54, 56, 57,
                    60, 63, 66, 69, 70,
                    72, 75, 77, 78, 81,
                    84, 87, 90, 91, 93,
                    96, 98, 99
                )
            )
        }

        'test_sumDivBy3or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 4) == 3)
            assert(Exercises.sumOfDivBy3Or5(1, 5) == 8)

            // если начинать с отрацательного
            assert(Exercises.sumOfDivBy3Or5(-3, 5) == 5)

            // если finish < start
            assert(Exercises.sumOfDivBy3Or5(-3, -5) == 0)

            // тест на больших числах
            assert(Exercises.sumOfDivBy3Or5(1, 21000) == 102910500)
        }

        'test_primeFactor - {
            // Примеры из описания
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
        }

       'test_sumScalar - {
         assert(Exercises.sumScalars(
           Vector2D(1, 3), Vector2D(-1, 4),
           Vector2D(1, 4), Vector2D(2, 3)) == 25
         )

         assert(Exercises.sumScalars(
           Vector2D(3, 2), Vector2D(1, 0),
           Vector2D(2, 4), Vector2D(5, 7)) == 41
         )
       }

      'test_sumCosines - {
        assert(Exercises.sumCosines(
          Vector2D(1, 3), Vector2D(-1, 4),
          Vector2D(1, 4), Vector2D(2, 3)) == 1.785403399326945
        )

        assert(Exercises.sumCosines(
          Vector2D(1, 0), Vector2D(1, 0),
          Vector2D(2, 0), Vector2D(0, 2)) == 1
        )
      }

      'sortByHeavyweight - {
        assert(
          Exercises.sortByHeavyweight(Map(
            "Vladek" -> (1, 3.14),
            "Vladislav" -> (2, 2.71)
          )) == List("Vladek", "Vladislav")
        )

        assert(
          Exercises.sortByHeavyweight(
          Exercises.balls
        ) == List("Tin", "Platinum", "Nickel",
          "Aluminum", "Titanium", "Lead",
          "Sodium", "Uranium", "Gold", "Tungsten",
          "Zirconium", "Chrome", "Iron", "Copper",
          "Silver", "Plutonium", "Cobalt", "Cesium",
          "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"))
      }
    }
}
