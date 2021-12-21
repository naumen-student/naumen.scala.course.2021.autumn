package app

object Main extends App {
  val name = "Ivan Medvedev"
  val reversedName = name.reverse

  val formatGreetings = (hello: String, name: String) => s"$hello Scala! This is $name"
  val greetings = "Hello" :: "Hola" :: "Guten tag" :: Nil

  println(formatGreetings(greetings.head, name))
  greetings.tail.map(formatGreetings(_, name)).foreach(println)
  greetings.map(formatGreetings(_, reversedName)).foreach(println)
}
