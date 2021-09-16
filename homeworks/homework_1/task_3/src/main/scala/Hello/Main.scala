package Hello

object Main extends App {
  def print_greeting(greeting: String, name: String): Unit = {
    println(greeting + " Scala! This is " + name)
  }

  val name = "Grisha Aydartsyan"
  val greetings = Array("Hello", "Hola", "Bonjour")
  for (greeting <- greetings){
    print_greeting(greeting, name)
    print_greeting(greeting, name.reverse)
  }
}
