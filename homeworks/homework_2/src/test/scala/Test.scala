import Exercises.Vector2D
import utest._

object Test extends TestSuite{

    val tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        };

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(10, 13) == 22)
            assert(Exercises.sumOfDivBy3Or5(1, 6)  == 14)
            assert(Exercises.sumOfDivBy3Or5(13, 14) == 0)
            assert(Exercises.sumOfDivBy3Or5(50, 60) ==  327)
            assert(Exercises.sumOfDivBy3Or5(-3, 5) == 5)
        };

        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(1) == Seq())
            assert(Exercises.primeFactor(525) == Seq(3, 5, 7))
            assert(intercept[Exception] {Exercises.primeFactor(0)}.getMessage == "Number can`t be zero")
        };

        'test_sumScalars - {
            assert(Exercises.sumScalars(new Vector2D(5, -4), new Vector2D(2, 1), new Vector2D(5, 2), new Vector2D(4, -1)) == 24)
            assert(Exercises.sumScalars(new Vector2D(1, 6), new Vector2D(5,3 ), new Vector2D(3, 7), new Vector2D(4, -2)) == 21)
            assert(Exercises.sumScalars(new Vector2D(1, 1), new Vector2D(-2,2), new Vector2D(3, 3), new Vector2D(4, -4)) == 0)
        }

        'test_sumCosines - {
            assert(Exercises.sumCosines(new Vector2D(3, 3), new Vector2D(5, 5), new Vector2D (5, -5), new Vector2D(6, -6)) == 2 )
            assert( Exercises.sumCosines(new Vector2D(4, 5), new Vector2D(5, 5), new Vector2D (5,4), new Vector2D(4,4) ) - 2 <= 1e-6)
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight( Map [String, (Int, Double)] ("common" -> (1, 1.0), "legendary" -> (3, 3.0), "rare" -> (2, 2.0) )) == Seq [String]("legendary", "rare", "common" ))
            assert(Exercises.sortByHeavyweight( Map [String, (Int, Double)] ("fooThird" -> (53, 0.0), "varSecond" -> (50, 1.0), "barFirst" -> (51, 2.0) )) == Seq [String]("barFirst", "varSecond", "fooThird" ))
        }

    }
}
