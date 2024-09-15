package example

object Main extends App {
  def printHelloLineByHelloAndName(hello: String, name:String): Unit = {
    println(hello + " Scala! This is " + name)
  }

  val name = "Danil Zheludkov"
  val names = Array(name, name.reverse)
  val hellos = Array("Hello", "Hola", "Guten tag")

  names.foreach(y => hellos.foreach(x => printHelloLineByHelloAndName(x, y)))
}
