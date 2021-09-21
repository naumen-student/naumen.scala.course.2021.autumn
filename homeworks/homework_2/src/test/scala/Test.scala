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
            assert(Exercises.sumOfDivBy3Or5(5, 9) == 5 + 6 + 9)
            assert(Exercises.sumOfDivBy3Or5(0, 100) == 0 + 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 + 20 + 21 + 24 + 25 + 27 + 30 + 33 + 35 + 36 + 39 + 40 + 42 + 45 + 48 + 50 + 51 + 54 + 55 + 57 + 60 + 63 + 65 + 66 + 69 + 70 + 72 + 75 + 78 + 80 + 81 + 84 + 85 + 87 + 90 + 93 + 95 + 96 + 99 + 100)
        }
        
        'test_primeFactor - {
            assert(Exercises.primeFactor(2*3) == Seq(2, 3))
            assert(Exercises.primeFactor(7) == Seq(7))
            assert(Exercises.primeFactor(3*3*11) == Seq(3, 11))
            assert(Exercises.primeFactor(2*3*4*5) == Seq(2, 3, 5))
            assert(Exercises.primeFactor(2*3*6) == Seq(2, 3))
        }
        
        'test_sumByFunc - {
			val eps = 0.000000001

            assert((Exercises.sumScalars(
				Exercises.Vector2D(3, 1),
				Exercises.Vector2D(3, 2),
				Exercises.Vector2D(7, 5),
				Exercises.Vector2D(0, 33)) - (3*3+1*2+7*0+5*33))
					< eps)

			assert(Exercises.sumScalars(
				Exercises.Vector2D(0, 0),
				Exercises.Vector2D(3, 2),
				Exercises.Vector2D(7, 5),
				Exercises.Vector2D(0, 0))
					< eps)

			assert((Exercises.sumCosines(
				Exercises.Vector2D(2, 0),
				Exercises.Vector2D(1, 1),
				Exercises.Vector2D(0, 7),
				Exercises.Vector2D(5, 5)) - java.lang.Math.sqrt(2))
					< eps)

			assert((Exercises.sumCosines(
				Exercises.Vector2D(3, 0),
				Exercises.Vector2D(2, 3.4641016151377544),
				Exercises.Vector2D(0, 5),
				Exercises.Vector2D(9.526279441628825, 5.5)) - 1)
					< eps)
        }
    }
}
