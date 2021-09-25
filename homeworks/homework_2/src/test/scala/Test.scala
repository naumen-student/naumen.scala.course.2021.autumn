import Exercises.Vector2D
import utest._

object Test extends TestSuite {

    val tests = Tests {
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
            assert(Exercises.primeFactor(3) == Seq(3))
            assert(Exercises.primeFactor(14) == Seq(2, 7))
            assert(Exercises.primeFactor(1) == Seq())
        }

        'test_sumByFunc - {
            assert(Exercises
              .sumScalars(new Vector2D(2,1), new Vector2D(1, 2),
                  new Vector2D(3,4), new Vector2D(4, 3)) == 28)
            assert(Exercises
              .sumCosines(new Vector2D(3,0), new Vector2D(0,5),
                  new Vector2D(0,7), new Vector2D(7,0)) == 0)
            /* тест на косинусы явно имел бы больше смысла, если бы я знал, как задать погрешность
            * double вычислений */
        }

        'test_sortByHeavyWeight - {
            val test_case = Map("Second" -> (2, 2.0),"First" -> (1, 1.0), "Third" -> (3, 3.0))
            assert(Exercises.sortByHeavyweight(test_case) == Seq("First", "Second", "Third"))

        }

    }
}
