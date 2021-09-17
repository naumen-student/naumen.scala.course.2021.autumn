package example

object Main extends App {
  var getString = (g: String, name: String) => g.concat(" Scala! This is ").concat(name)
  var greetings = List("Hello", "Hola", "Guten tag")
  var name = "Evelina Yametova"
  greetings.foreach(g => println(getString(g,name)))
  greetings.foreach(g => println(getString(g,name.reverse)))
}
