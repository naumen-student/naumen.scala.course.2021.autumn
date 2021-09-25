import Exercises.Vector2D
import utest._

object Test extends TestSuite{

    val tests: Tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(5, 12) == 42)
            assert(Exercises.sumOfDivBy3Or5(0, 100) == 2418)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(9) == Seq(3))
            assert(Exercises.primeFactor(24) == Seq(2, 3))
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
        }

        'test_Vector2D_sumScalars - {
            assert(
                Exercises.sumScalars(
                    Vector2D(0, 0), Vector2D(1, 1),
                    Vector2D(1, 1), Vector2D(0, 0)
                ) == 0
            )

            assert(
                Exercises.sumScalars(
                    Vector2D(2, 0), Vector2D(0, 2),
                    Vector2D(1, 1), Vector2D(1, 1)
                ) == 2
            )

            assert(
                Exercises.sumScalars(
                    Vector2D(1, 2), Vector2D(2, 1),
                    Vector2D(1, 1), Vector2D(2, 2)
                ) == 8
            )
        }

        'test_Vector2D_sumScalars - {
            assert(Exercises.sumCosines(
                Vector2D(1, 0), Vector2D(1, 0),
                Vector2D(2, 0), Vector2D(0, 2)) == 1
            )

            assert(Exercises.sumCosines(
                Vector2D(-1, -1), Vector2D(1, 1),
                Vector2D(1, 1), Vector2D(1, 1)) == 0
            )
        }

        'test_sortByWeight - {
            val languages: Map[String, (Int, Double)] = Map (
                "Scala" -> (5, 3),
                "C#" -> (2, 5),
                "Java" -> (1, 20)
            )

            assert(Exercises.sortByHeavyweight(languages) == Seq("Java", "C#", "Scala"))

            val balls1: Map[String, (Int, Double)] = Map(
                    "Aluminum" -> (3,   2.6889),
                    "Tungsten" ->  (2,   19.35),
                    "Graphite" ->  (12,  2.1)
                )

            assert(Exercises.sortByHeavyweight(balls1) == Seq("Aluminum", "Tungsten", "Graphite"))

            val balls2: Map[String, (Int, Double)] = Map(
                    "Gold" -> (2,   19.32),
                    "Potassium" -> (14,  0.862),
                    "Calcium" ->   (8,   1.55),
                    "Cobalt" -> (4,   8.90),
                )

            assert(Exercises.sortByHeavyweight(balls2) == Seq("Gold", "Cobalt", "Calcium", "Potassium"))
        }
    }
}
