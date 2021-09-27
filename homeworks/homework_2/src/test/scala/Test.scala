import utest._

object Test extends TestSuite{

    val tests: Tests = Tests{
        Symbol("test_divBy3Or7") - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        Symbol("test_sumOfDivBy3Or5") - {
            assert(Exercises.sumOfDivBy3Or5(3, 10) == 33)
            assert(Exercises.sumOfDivBy3Or5(0, 1) == 0)
            assert(Exercises.sumOfDivBy3Or5(-5, 6) == 6)
            assert(Exercises.sumOfDivBy3Or5(5, 0) == 0)
        }
        Symbol("test_getPrimeNumbers") - {
            assert(Exercises.getPrimeNumbers(10) == Seq(2, 3, 5, 7))
        }
        Symbol("test_primeFactor") - {
            assert(Exercises.primeFactor(10) == Seq(2, 5))
            assert(Exercises.primeFactor(98) == Seq(2, 7))
            assert(Exercises.primeFactor(0) == Seq())
        }
        Symbol("test_createBallMassMap") - {
            val inMap: Map[String, (Int, Double)] = Map("a" -> (3, 5), "b" -> (2, 7), "c" ->  (12, 1), "d" -> (3, 3))
            val assertMap = Map("a" -> 135, "b" -> 56, "c" -> 1728, "d" -> 81)
            assert(Exercises.createBallDiffMap(inMap) == assertMap)
        }
        Symbol("test_sortByHeavyweight") - {
            val inMap: Map[String, (Int, Double)] = Map("a" -> (3, 5), "b" -> (2, 7), "c" ->  (12, 1), "d" -> (3, 3))
            assert(Exercises.sortByHeavyweight(inMap) == Seq("b", "d", "a", "c"))
        }
        Symbol("test_sumByFunc") - {
            val vec1 = Exercises.Vector2D(1, 3)
            val vec2 = Exercises.Vector2D(-3, 2)
            val vec3 = Exercises.Vector2D(0, 4)
            val vec4 = Exercises.Vector2D(7, 3)
            assert(Exercises.sumScalars(vec1, vec2, vec3, vec4) == Exercises.scalar(vec1, vec2) + Exercises.scalar(vec3, vec4))
            assert(Exercises.sumCosines(vec1, vec2, vec3, vec4) == Exercises.cosBetween(vec1, vec2) + Exercises.cosBetween(vec3, vec4))
        }
    }
}
