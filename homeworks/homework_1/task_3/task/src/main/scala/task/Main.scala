package task

object Main extends App {
  val name = "Ira Serebrennikova"
  val words = List("Hello", "Hi", "Hola")

  words.foreach(word => println(word + " Scala! This is " + name))
  words.foreach(word => println(word + " Scala! This is " + name.reverse))
}
