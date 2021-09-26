import Exercises._
import utest._

object Test extends TestSuite{

    val tests: Tests = Tests{
        'test_divBy3Or7 - {
            assert(divBy3Or7(1, 3) == Seq(3))
            assert(divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'sumOfDivBy3Or5 - {
            assert(sumOfDivBy3Or5(4, 4) == 0)
            assert(sumOfDivBy3Or5(5, 5) == 5)
            assert(sumOfDivBy3Or5(1, 20) == 98)
        }

        'primeFactor - {
            assert(primeFactor(80) == List(2, 5))
            assert(primeFactor(98) == List(2, 7))
            assert(primeFactor(7) == List(7))
            assert(primeFactor(103) == List(103))
            assert(primeFactor(1) == List())

        }

        'sumScalars - {
            assert(sumScalars(Vector2D(4, 3), Vector2D(3, 4), Vector2D(1, 3), Vector2D(5, 1)) == 32)
            assert(sumScalars(Vector2D(4, 0), Vector2D(0, 4), Vector2D(0, 3), Vector2D(5, 0)) == 0)
            assert(sumScalars(Vector2D(4, 1), Vector2D(1, 4), Vector2D(0, 3), Vector2D(5, 0)) == 8)
            assert(sumScalars(Vector2D(4, 0), Vector2D(0, 4), Vector2D(1, 3), Vector2D(5, 1)) == 8)
        }

        'sumCosines - {
            assert(sumCosines(Vector2D(2, 0), Vector2D(2, 0), Vector2D(0, 2), Vector2D(0, 2)) == 2)
            assert(sumCosines(Vector2D(2, 0), Vector2D(0, 2), Vector2D(0, 2), Vector2D(2, 0)) == 0)
            assert(sumCosines(Vector2D(2, 2), Vector2D(2, -2), Vector2D(-2, 2), Vector2D(-2, -2)) == 0)
        }
    }
}
