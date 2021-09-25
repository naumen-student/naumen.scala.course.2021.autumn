object Main extends App {
  val greetings = List("Hello", "Hola", "Guten tag")
  val names = List("Alisher", "reshilA")
  names foreach (name => greetings foreach (greeting => println(s"$greeting Scala! This is $name")))
}
