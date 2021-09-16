object Main extends App {
  val myName: String = "Vlad"
  println(f"Hello Scala! This is ${myName}")

  val Greetings = List("Hello", "Hola", "Guten tag")
  for (greeting <- Greetings) println(f"${greeting} Scala! This is ${myName}")

  for (greeting <- Greetings) println(f"${greeting} Scale! This is ${myName.reverse}")
}

