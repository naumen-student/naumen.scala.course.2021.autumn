package example

object Main extends App {
  val name = "Yaroslav"
  var greetings = List("Hello", "Hola", "Guten Tag")

  def hello(s: String, n: String): Unit = {
    println(s + " Scala! This is " + n)
  }

  for (greets <- greetings) hello(greets, name)
  println()
  for (greets <- greetings) hello(greets, name.reverse)
}