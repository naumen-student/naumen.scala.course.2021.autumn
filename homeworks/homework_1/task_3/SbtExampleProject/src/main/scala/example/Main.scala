package  example

object Main extends App {
  var str = " Scala! This is "
  var name = "Lera"
  var greeting = List("Hello", "Hola", "Hi")

  def hello(greeting: List[String], name: String): Unit = {
    greeting.foreach(s => println(s + str + name))
  }

  hello(greeting, name)
}