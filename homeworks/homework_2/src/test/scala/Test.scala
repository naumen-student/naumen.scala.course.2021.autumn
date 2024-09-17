import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(0, 0) == 0) // надо бы без переписывания этого всего) foreach-ем листа какого-нибудь
            assert(Exercises.sumOfDivBy3Or5(0, 1) == 0)
            assert(Exercises.sumOfDivBy3Or5(0, 2) == 0)
            assert(Exercises.sumOfDivBy3Or5(0, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(0, 4) == 3)
            assert(Exercises.sumOfDivBy3Or5(0, 5) == 3 + 5)
            assert(Exercises.sumOfDivBy3Or5(0, 10) == 3 + 5 + 6 + 9 + 10)
            assert(Exercises.sumOfDivBy3Or5(3, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(5, 5) == 5)
            assert(Exercises.sumOfDivBy3Or5(3, 5) == 3 + 5)
            assert(Exercises.sumOfDivBy3Or5(4, 17) == 5 + 6 + 9 + 10 + 12 + 15)
            assert(Exercises.sumOfDivBy3Or5(45, 59) == 45 + 48 + 50 + 51 + 54 + 55 + 57)
            assert(Exercises.sumOfDivBy3Or5(-1, 0) == 0)
            assert(Exercises.sumOfDivBy3Or5(-3, 0) == -3)
            assert(Exercises.sumOfDivBy3Or5(-5, 0) == - 5 - 3)
            assert(Exercises.sumOfDivBy3Or5(-5, -3) == - 5 - 3)
            assert(Exercises.sumOfDivBy3Or5(-59, -45) == -57 - 55 - 54 - 51 - 50 - 48 - 45)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(1) == Seq())
            assert(Exercises.primeFactor(2) == Seq(2))
            assert(Exercises.primeFactor(3) == Seq(3))
            assert(Exercises.primeFactor(5) == Seq(5))
            assert(Exercises.primeFactor(11) == Seq(11))
            assert(Exercises.primeFactor(997) == Seq(997))
            assert(Exercises.primeFactor(4) == Seq(2))
            assert(Exercises.primeFactor(6) == Seq(2, 3))
            assert(Exercises.primeFactor(12) == Seq(2, 3))
            assert(Exercises.primeFactor(36) == Seq(2, 3))
            assert(Exercises.primeFactor(77) == Seq(7, 11))
            assert(Exercises.primeFactor(2 * 3 * 5) == Seq(2, 3, 5))
            assert(Exercises.primeFactor(2 * 2 * 3 * 7) == Seq(2, 3, 7))
            assert(Exercises.primeFactor(3 * 7 * 7 * 7 * 7) == Seq(3, 7))
            assert(Exercises.primeFactor(2 * 3 * 5 * 7) == Seq(2, 3, 5, 7))
            assert(Exercises.primeFactor(13 * 13 * 17 * 29 * 29) == Seq(13, 17, 29))
        }

        val zeroVec = Exercises.Vector2D(0, 0)
        val xUnitVec = Exercises.Vector2D(1, 0)
        val yUnitVec = Exercises.Vector2D(0, 1)
        val diagVec = Exercises.Vector2D(1, 1)

        val vec1 = Exercises.Vector2D(0.5, 0.7)
        val vec2 = Exercises.Vector2D(-0.3, 0.4)
        val vec3 = Exercises.Vector2D(-1.7, -2.3)
        val vec4 = Exercises.Vector2D(4.2, 1)

        implicit class RichInt(x: Double) {
            def isClose(y: Double): Boolean = math.abs(x - y) < 1e-5
        }

        'test_sumScalars - {
            assert(Exercises.sumScalars(zeroVec, zeroVec, zeroVec, zeroVec).isClose(0))
            assert(Exercises.sumScalars(zeroVec, vec4, vec2, zeroVec).isClose(0))
            assert(Exercises.sumScalars(zeroVec, vec1, vec2, xUnitVec).isClose(-0.3))
            assert(Exercises.sumScalars(vec1, vec2, vec3, vec4).isClose(-9.31))
            assert(Exercises.sumScalars(yUnitVec, diagVec, vec2, vec3).isClose(0.59))
        }

        'test_sumCosines - {
            assert(Exercises.sumCosines(zeroVec, zeroVec, zeroVec, zeroVec).isNaN)
            assert(Exercises.sumCosines(zeroVec, vec4, vec2, zeroVec).isNaN)
            assert(Exercises.sumCosines(zeroVec, vec1, vec2, xUnitVec).isNaN)
            assert(Exercises.sumCosines(vec1, vec2, vec3, vec4).isClose(-0.462247))
            assert(Exercises.sumCosines(yUnitVec, diagVec, vec2, vec3).isClose(0.420401))
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Map("A" -> (1, 1), "B" -> (2, 0.5), "C" -> (1, 2))) == Seq("A", "C", "B"))
            assert(Exercises.sortByHeavyweight(Map("A" -> (1, 150), "B" -> (1, 151), "C" -> (0, 125))) == Seq("C", "A", "B"))
            assert(Exercises.sortByHeavyweight(Map("Abc" -> (5, 20), "Cde" -> (6, 11.76), "Efg" -> (6, 11.11))) == Seq("Efg", "Abc", "Cde"))
        }
    }
}
