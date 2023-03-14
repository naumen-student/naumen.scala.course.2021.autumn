import utest._

import java.text.DecimalFormat

object Test extends TestSuite {

  val tests = Tests {
    'test_divBy3Or7 - {
      assert(Exercises.divBy3Or7(1, 3) == Seq(3))
      assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
      assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
      assert(Exercises.divBy3Or7(7, 14) == Seq(7, 9, 12, 14))
      assert(Exercises.divBy3Or7(-14, 14) == Seq(-14, -12, -9, -7, -6, -3, 0, 3, 6, 7, 9, 12, 14))
      assert(Exercises.divBy3Or7(-7, 14) == Seq(-7, -6, -3, 0, 3, 6, 7, 9, 12, 14))
      assert(Exercises.divBy3Or7(50, 100) == Seq(51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
    }
    'test_sumOfDivBy3Or5 - {
      assert(Exercises.sumOfDivBy3Or5(0, 3) == 3)
      assert(Exercises.sumOfDivBy3Or5(0, 5) == 8)
      assert(Exercises.sumOfDivBy3Or5(0, 8) == 14)
      assert(Exercises.sumOfDivBy3Or5(0, 11) == 33)
      assert(Exercises.sumOfDivBy3Or5(10, 15) == 37)
      assert(Exercises.sumOfDivBy3Or5(14, 15) == 15)
      assert(Exercises.sumOfDivBy3Or5(1, 3) == 3)
      assert(Exercises.sumOfDivBy3Or5(1, 5) == 8)
      assert(Exercises.sumOfDivBy3Or5(-15, 15) == 0)
      assert(Exercises.sumOfDivBy3Or5(-10, 15) == 27)
      assert(Exercises.sumOfDivBy3Or5(-9, 15) == 37)
    }

    'test_primeFactor - {
      assert(Exercises.primeFactor(80) == Seq(1, 2, 2, 2, 2, 5))
      assert(Exercises.primeFactor(-80) == Seq(-1, 2, 2, 2, 2, 5))
      assert(Exercises.primeFactor(98) == Seq(1, 2, 7, 7))
      assert(Exercises.primeFactor(-98) == Seq(-1, 2, 7, 7))
      assert(Exercises.primeFactor(8) == Seq(1, 2, 2, 2))
      assert(Exercises.primeFactor(-8) == Seq(-1, 2, 2, 2))
      assert(Exercises.primeFactor(12) == Seq(1, 2, 2, 3))
      assert(Exercises.primeFactor(-12) == Seq(-1, 2, 2, 3))
      assert(Exercises.primeFactor(60) == Seq(1, 2, 2, 3, 5))
      assert(Exercises.primeFactor(-60) == Seq(-1, 2, 2, 3, 5))
      assert(Exercises.primeFactor(3780) == Seq(1, 2, 2, 3, 3, 3, 5, 7))
      assert(Exercises.primeFactor(-3780) == Seq(-1, 2, 2, 3, 3, 3, 5, 7))
      assert(Exercises.primeFactor(245) == Seq(1, 5, 7, 7))
      assert(Exercises.primeFactor(-245) == Seq(-1, 5, 7, 7))
    }

    'test_sumByFunc - {
      val scalar = 0
      val cosBetween = 1

      var v11 = Exercises.Vector2D(10, 0)
      var v12 = Exercises.Vector2D(0, 10)
      var v13 = Exercises.Vector2D(-10, 0)
      var v14 = Exercises.Vector2D(0, -10)

      val df = new DecimalFormat("#.###########")


      assert(Exercises.sumByFunc(v11, v12, scalar, v13, v14) == 0.0)
      assert(Exercises.sumByFunc(v11, v12, scalar, v11, v12) == 0.0)
      assert(df.format(Exercises.sumByFunc(v11, v12, cosBetween, v13, v14)) == "0")
      assert(df.format(Exercises.sumByFunc(v11, v12, cosBetween, v11, v12)) == "0")

      v11 = Exercises.Vector2D(10, 1)
      v12 = Exercises.Vector2D(1, 10)
      v13 = Exercises.Vector2D(20, 1)
      v14 = Exercises.Vector2D(1, 20)

      assert(Exercises.sumByFunc(v11, v12, scalar, v11, v12) == 40.0)
      assert(Exercises.sumByFunc(v11, v12, scalar, v13, v14) == 60.0)
      assert(df.format(Exercises.sumByFunc(v11, v12, cosBetween, v13, v14)) == "0,29777042542")
      assert(df.format(Exercises.sumByFunc(v11, v12, cosBetween, v11, v12)) == "0,39603960396")

      v11 = Exercises.Vector2D(-10, 1)
      v12 = Exercises.Vector2D(-1, 10)
      v13 = Exercises.Vector2D(-20, 1)
      v14 = Exercises.Vector2D(-1, 20)

      assert(Exercises.sumByFunc(v11, v12, scalar, v11, v12) == 40.0)
      assert(Exercises.sumByFunc(v11, v12, scalar, v13, v14) == 60.0)
      assert(df.format(Exercises.sumByFunc(v11, v12, cosBetween, v13, v14)) == "0,29777042542")
      assert(df.format(Exercises.sumByFunc(v11, v12, cosBetween, v11, v12)) == "0,39603960396")
    }

    'test_sortByHeavyweight - {
      val balls1: Map[String, (Int, Double)] =
        Map(
          "Aluminum" -> (1, 1),
          "Tungsten" -> (2, 1),
          "Graphite" -> (3, 1),
          "Iron" -> (4, 1),
          "Gold" -> (5, 1)
        )

      val balls2: Map[String, (Int, Double)] =
        Map(
          "Aluminum" -> (5, 1),
          "Tungsten" -> (4, 1),
          "Graphite" -> (3, 1),
          "Iron" -> (2, 1),
          "Gold" -> (1, 1)
        )

      val balls3: Map[String, (Int, Double)] =
        Map(
          "Aluminum" -> (3, 2.6889), "Tungsten" -> (2, 19.35), "Graphite" -> (12, 2.1), "Iron" -> (3, 7.874),
          "Gold" -> (2, 19.32), "Potassium" -> (14, 0.862), "Calcium" -> (8, 1.55), "Cobalt" -> (4, 8.90),
          "Lithium" -> (12, 0.534), "Magnesium" -> (10, 1.738), "Copper" -> (3, 8.96), "Sodium" -> (5, 0.971),
          "Nickel" -> (2, 8.91), "Tin" -> (1, 7.29), "Platinum" -> (1, 21.45), "Plutonium" -> (3, 19.25),
          "Lead" -> (2, 11.336), "Titanium" -> (2, 10.50), "Silver" -> (4, 4.505), "Uranium" -> (2, 19.04),
          "Chrome" -> (3, 7.18), "Cesium" -> (7, 1.873), "Zirconium" -> (3, 6.45)
        )

      val balls4: Map[String, (Int, Double)] =
        Map(
          "Tin" -> (1, 7.29),
          "Tungsten" -> (2, 19.35),
          "Aluminum" -> (3, 2.6889),
          "Cobalt" -> (4, 8.90),
          "Sodium" -> (5, 0.971)
        )

      val balls5: Map[String, (Int, Double)] =
        Map(
          "Tin" -> (1, 7.29),
          "Tungsten" -> (-2, 19.35),
          "Aluminum" -> (3, 2.6889),
          "Cobalt" -> (-4, 8.90),
          "Sodium" -> (5, 0.971)
        )

      assert(Exercises.sortByHeavyweight(balls1) == Seq("Aluminum", "Tungsten", "Graphite", "Iron", "Gold"))
      assert(Exercises.sortByHeavyweight(balls2) == Seq("Gold", "Iron", "Graphite", "Tungsten", "Aluminum"))
      assert(Exercises.sortByHeavyweight(balls3) == Seq("Sodium", "Lithium", "Tin", "Aluminum", "Potassium", "Calcium", "Cesium", "Magnesium", "Nickel", "Silver", "Zirconium", "Titanium", "Platinum", "Chrome", "Lead", "Iron", "Graphite", "Copper", "Cobalt", "Uranium", "Gold", "Tungsten", "Plutonium"))
      assert(Exercises.sortByHeavyweight(balls4) == Seq("Sodium", "Tin", "Aluminum", "Cobalt", "Tungsten"))
      assert(Exercises.sortByHeavyweight(balls5) == Seq("Tungsten", "Cobalt", "Sodium", "Tin", "Aluminum"))
    }
  }
}
