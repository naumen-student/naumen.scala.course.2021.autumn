package task_3

object main extends App {
  val name = "Andrey Bronnikov"
  val name_reversed = name.reverse
  val greetings = "Hello"
  val greetings_ru = "Privet"
  val greetings_fr = "Bonjour"
  var hellos = Array (greetings, greetings_fr, greetings_ru )
  def hello(s: String, x: String): Unit = {
    println( s + " Scala! This is "+ x + ".")
  }
  for ( x <- hellos ) {
    hello(x,name)
  }
  for ( x <- hellos ) {
    hello(x,name_reversed)
  }

}
