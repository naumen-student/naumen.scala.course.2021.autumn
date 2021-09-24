import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(5, 9) == 22)
            assert(Exercises.sumOfDivBy3Or5(0, 100) == 2208)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
        }
        'test_sumScalars - {
            assert(Exercises.sumScalars(
                Exercises.Vector2D(2, 3),
                Exercises.Vector2D(1, 2),
                Exercises.Vector2D(2, 2),
                Exercises.Vector2D(1, 1)) == 12)

            assert(Exercises.sumScalars(
                Exercises.Vector2D(0, 3),
                Exercises.Vector2D(1, 0),
                Exercises.Vector2D(2, 1),
                Exercises.Vector2D(2, 4)) == 8)
        }
        'test_sumCosines - {
            assert(Math.abs(Exercises.sumCosines(
                Exercises.Vector2D(0, 2),
                Exercises.Vector2D(3, 0),
                Exercises.Vector2D(1, 1),
                Exercises.Vector2D(2, 2)) - 1) < 0.01)

            assert(Math.abs(Exercises.sumCosines(
                Exercises.Vector2D(1, 2),
                Exercises.Vector2D(2, 1),
                Exercises.Vector2D(0, 1),
                Exercises.Vector2D(2, 0)) - 0.8) < 0.01)
        }
        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight().head.equals("Tin"))
            assert(Exercises.sortByHeavyweight().last.equals("Graphite"))

            val map = Map("a" -> (3, 1.5), "b" -> (5, 2.1), "c" -> (2, 3.1))
            assert(Exercises.sortByHeavyweight(map).equals(Seq("c", "a", "b")))
        }
    }
}
