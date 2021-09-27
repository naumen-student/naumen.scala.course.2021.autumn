import Exercises.{Vector2D, balls}
import utest._

object Test extends TestSuite{

    val tests = Tests {
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }

        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
            assert(Exercises.sumOfDivBy3Or5(5, 9) == 20)
            assert(Exercises.sumOfDivBy3Or5(0, 0) == 0)
        }

        'test_primeFactor - {
            assert(Exercises.primeFactor(15) == Seq(3, 5))
            assert(Exercises.primeFactor(256) == Seq(2))
            assert(Exercises.primeFactor(767) == Seq(13, 59))
            assert(Exercises.primeFactor(105) == Seq(3, 5, 7))
        }

        'test_Vector2D - {
            'sameVector - {
                val vector = Vector2D(2, 7)
                'scalar - {
                    assert(Exercises.sumByFunc(vector, vector, Exercises.scalar, vector, vector) == 106)
                }
                'cosBetween - {
                    assert(Exercises.sumByFunc(vector, vector, Exercises.cosBetween, vector, vector) == 2)
                }
            }

            'differentVectors1 - {
                val leftVec0 = Vector2D(10, 3)
                val leftVec1 = Vector2D(5, 7)
                val rightVec0 = Vector2D(9, 4)
                val rightVec1 = Vector2D(23, 11)
                'scalar - {
                    assert(Exercises.sumByFunc(leftVec0, leftVec1, Exercises.scalar, rightVec0, rightVec1) == 322)
                }
                'cosBetween - {
                    val value = Exercises.sumByFunc(leftVec0, leftVec1, Exercises.cosBetween, rightVec0, rightVec1)
                    assert(BigDecimal(value).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble == 1.79)
                }
            }

            'differentVectors2 - {
                val leftVec0 = Vector2D(4, 4)
                val leftVec1 = Vector2D(5, 5)
                val rightVec0 = Vector2D(6, 6)
                val rightVec1 = Vector2D(7, 7)
                'scalar - {
                    assert(Exercises.sumByFunc(leftVec0, leftVec1, Exercises.scalar, rightVec0, rightVec1) == 124)
                }
                'cosBetween - {
                    assert(Exercises.sumByFunc(leftVec0, leftVec1, Exercises.cosBetween, rightVec0, rightVec1) == 2)
                }
            }
        }

        'test_sortByHeavyweight - {
            assert(Exercises.sortByHeavyweight(balls) == Seq("Tin", "Platinum", "Nickel", "Aluminum", "Titanium", "Lead", "Sodium", "Uranium", "Gold", "Tungsten", "Zirconium", "Chrome", "Iron", "Copper", "Silver", "Plutonium", "Cobalt", "Cesium", "Calcium", "Lithium", "Magnesium", "Potassium", "Graphite"))
        }
    }
}
