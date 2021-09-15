package example

object Main extends App {
  def sayHello(hello: String, name: String): Unit = println(s"$hello Scala! This is $name")
  var name = "Anya"
  var helloPhrases = Array("Hello", "Hola", "Guten tag")
  helloPhrases.foreach(hello => sayHello(hello, name))
  helloPhrases.foreach(hello => sayHello(hello, name.reverse))
}
