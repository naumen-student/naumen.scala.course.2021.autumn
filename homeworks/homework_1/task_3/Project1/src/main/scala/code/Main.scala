package code

object Main extends App
{
  var name = "Artem Slivnyi"
  var revertName = name.reverse
  val arr = Array("Hello", "Bonjour", "Hola")
  for (x <- arr) println(s"$x Scala! This is #name")
  println(s"Hello Scala! This is $name")
  println(s"Bonjour Scala! This is $name")
  println(s"Hola Scala! This is $name")
  var a = s"Hello Scala! This is $name"
  var a1 = s"Hello Scala! This is $revertName"
  var b1 = s"Bonjour Scala! This is $revertName"
  var b = s"Bonjour Scala! This is $name"
  println(a + b)
  println(a + ' ' + b)
  println(b1 + ' ' + a1)
  println(0.0 + 1)
}
