package example

object Main extends App {
  val name = "Maria Dyuzheva"
  val printGreeting = (x: String, y: String) => println(x + " Scala! This is " + y)
  val greetings = Array("Hello", "Hola", "Guten tag")
  greetings.foreach(printGreeting(_, name))

  val revName = name.reverse
  greetings.foreach(printGreeting(_, revName))
}
