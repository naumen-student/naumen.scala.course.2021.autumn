import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(10, 20) == 75)
            assert(Exercises.sumOfDivBy3Or5(15, 30) == 180)
            assert(Exercises.sumOfDivBy3Or5(30, 60) == 675)
            assert(Exercises.sumOfDivBy3Or5(60, 120) == 2610)
            assert(Exercises.sumOfDivBy3Or5(120, 240) == 10260)
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(5) == Seq(5))
            assert(Exercises.primeFactor(37) == Seq(37))
            assert(Exercises.primeFactor(80) == Seq(2, 5))
            assert(Exercises.primeFactor(112) == Seq(2, 7))
            assert(Exercises.primeFactor(145) == Seq(5, 29))
        }
        'test_sumByFunc - {
            assert(Exercises.sumScalars(
                Exercises.Vector2D(2,0),
                Exercises.Vector2D(2,1),
                Exercises.Vector2D(2,0),
                Exercises.Vector2D(4,3)) == 12.0)
            assert(Exercises.sumScalars(
                Exercises.Vector2D(12,21),
                Exercises.Vector2D(4,8),
                Exercises.Vector2D(15,0),
                Exercises.Vector2D(12,9)) == 396.0)
            assert(Exercises.sumScalars(
                Exercises.Vector2D(6,10),
                Exercises.Vector2D(22,1),
                Exercises.Vector2D(12,0),
                Exercises.Vector2D(4,23)) == 190.0)
            assert(Exercises.sumCosines(
                Exercises.Vector2D(2,0),
                Exercises.Vector2D(2,1),
                Exercises.Vector2D(2,0),
                Exercises.Vector2D(4,3)) == 1.694427190999916)
            assert(Exercises.sumCosines(
                Exercises.Vector2D(12,21),
                Exercises.Vector2D(4,8),
                Exercises.Vector2D(15,0),
                Exercises.Vector2D(12,9)) == 1.7984603532054124)
            assert(Exercises.sumCosines(
                Exercises.Vector2D(6,10),
                Exercises.Vector2D(22,1),
                Exercises.Vector2D(12,0),
                Exercises.Vector2D(4,23)) == 0.7242429965059756)
        }
        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(Exercises.balls) == Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten", "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"))
        }
    }
}
