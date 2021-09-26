import Exercises.Vector2D
import utest._

import scala.language.implicitConversions

object Test extends TestSuite {

    implicit def toVector(t: (Int, Int)): Vector2D = Vector2D(t._1, t._2)

    val tests: Tests = Tests {
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
            assert(Exercises.primeFactor(1) == Nil)
            assert(Exercises.primeFactor(5) == 5 :: Nil)
            assert(Exercises.primeFactor(16) == 2 :: Nil)
            assert(Exercises.primeFactor(162) == Seq(2, 3))
            assert(Exercises.primeFactor(102) == Seq(2, 3, 17))
            assert(Exercises.primeFactor(97) == Seq(97))
        }

        'test_sumScalars - {
            assert(Exercises.sumScalars((1, 1), (2, 2), (3, 3), (4, 4)) == 28)
        }

        def round3(d: Double): Double = d - (d % 0.001)

        'test_sumCosines - {
            assert(round3(Exercises.sumCosines((1, 0), (1, 1), (1, 0), (0, 1))) == round3(Math.sqrt(2) / 2))
        }

        val balls: Map[String, (Int, Double)] =
            Map(
                "Aluminum" -> (3, 2.6889),
                "Tungsten" -> (2, 19.35),
                "Graphite" -> (12, 2.1),
                "Iron"     -> (3, 7.874)
            )

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(balls) == Seq("Aluminum", "Iron", "Tungsten", "Graphite"))
        }
    }
}
