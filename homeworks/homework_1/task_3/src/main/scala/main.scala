object main extends App{
  println("Hello Scala! This is Lev")

  val name = "Lev"

  println(s"Hola Scala! This is $name")

  println(s"Guten tag Scala! This is $name")

  val message = "Scala! This is"

  println(s"Hi $message" + name.reverse)

  println(s"Hi $message " + name.reverse)

  println(s"Hello $message " + name.reverse)

  println(s"Hola $message " + name.reverse)

  println(s"Guten tag $message " + name.reverse)
}