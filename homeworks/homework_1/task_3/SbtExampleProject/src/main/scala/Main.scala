object Main extends App{
  var name = "Ilya"
  var hello = Array("Hello", "Hi", "Dobroe ytro")
  def printHello(name: String, hello: String) = println(s"$hello Scala! This is $name")

  hello.foreach(h => printHello(name, h))
  println("")
  hello.foreach(h => printHello(name.reverse, h))
}
