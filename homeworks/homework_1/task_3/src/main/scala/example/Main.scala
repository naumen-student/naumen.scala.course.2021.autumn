package example

object Main extends App {
  val name = "Inna Anikina"
  val greetings = Array("Hello", "Hola", "Ciao")

  def print_greetings(name:String, greetings:Array[String]):Unit = {
    for (greeting <- greetings) {
      println(s"${greeting} Scala! This is ${name}")
    }
  }

  print_greetings(name, greetings)
  print_greetings(name.reverse, greetings)
}
