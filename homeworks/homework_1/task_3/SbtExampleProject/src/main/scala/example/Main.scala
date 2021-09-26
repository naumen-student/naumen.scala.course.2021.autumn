package example

object Main extends App {
  def hello(myName: String, greetings: Array[String]): Unit = {
    for (greeting <- greetings) println(s"$greeting Scala! This is $myName")
  }

  var myName = "Maxim Dyachenko"
  var greetings = Array("Hello", "Hola", "Guten tag")
  hello(myName, greetings)
  hello(myName.reverse, greetings)
}
