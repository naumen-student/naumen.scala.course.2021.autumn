import utest._
import scala.util.Random

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        }
        'test_sumOfDivBy3Or5 - {
            assert(Exercises.sumOfDivBy3Or5(10, 15) == 37)
            assert(Exercises.sumOfDivBy3Or5(11, 15) == 27)
            assert(Exercises.sumOfDivBy3Or5(1, 2) == 0)
            assert(Exercises.sumOfDivBy3Or5(3, 2) == 0)
        }
        'test_sumCosines - {
            val vv1 = Exercises.Vector2D(0,1)
            val vv2 = Exercises.Vector2D(1,0)
            assert(Exercises.sumCosines(vv1,vv2,vv1,vv2) == 0)
            val x = Random.nextDouble()
            val y = Random.nextDouble()
            val z = Random.nextDouble()
            val w = Random.nextDouble()
            val v1 = Exercises.Vector2D(x,y)
            val v2 = Exercises.Vector2D(y,x)
            val v3 = Exercises.Vector2D(z,w)
            val v4 = Exercises.Vector2D(w,z)
            assert(Exercises.sumCosines(v1,v2,v3,v4) == Exercises.cosBetween(v1, v2) + Exercises.cosBetween(v3, v4))
        }
        'test_sumScalars - {
            val u1 = Exercises.Vector2D(0,1)
            val u2 = Exercises.Vector2D(1,0)
            assert(Exercises.sumScalars(u1,u2,u1,u2) == 0)
            assert(Exercises.sumScalars(u1,u1,u1,u2) == 1)
            assert(Exercises.sumScalars(u1,u2,u2,u2) == 1)
            assert(Exercises.sumScalars(u2,u2,u2,u2) == 2)
            val x = Random.nextDouble()
            val y = Random.nextDouble()
            val z = Random.nextDouble()
            val w = Random.nextDouble()
            val v1 = Exercises.Vector2D(x,y)
            val v2 = Exercises.Vector2D(y,x)
            val v3 = Exercises.Vector2D(z,w)
            val v4 = Exercises.Vector2D(w,z)
            assert(Exercises.sumScalars(v1,v2,v3,v4) == Exercises.scalar(v1, v2) + Exercises.scalar(v3, v4))
        }
        'test_sortByHeavyweight - {
            val balls: Map[String, (Int, Double)] =
                Map(
                    "Al" -> (1,   2.6889), "Tu" ->  (1,   19.35), "Gr" ->  (1,  2.1),   "Ir" ->      (1,   7.874),
                )
            assert(Exercises.sortByHeavyweight(balls) == Seq("Gr", "Al", "Ir", "Tu"))
        }
        'test_primeFactor - {
            assert(Exercises.primeFactor(2) == Seq())
            assert(Exercises.primeFactor(80) == Seq(2,5))
            assert(Exercises.primeFactor(98) == Seq(2,7))

        }
    }
}
