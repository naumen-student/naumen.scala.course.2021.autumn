package example

object Main extends App{
  def changeBeginning(beginning: String, line: String): String = {
    val len = line.indexOf(' ')
    beginning + line.substring(len);
  }

  var greeting = "Hello Scala! This is Alexandra"
  println(greeting)


  greeting = changeBeginning("Hola", greeting)
  println(greeting)

  greeting = changeBeginning("Guten tag", greeting)
  println(greeting)

  val nameRev = "Alexandra".reverse
  greeting = "Hello Scala! This is" + nameRev
  println(greeting)

  greeting = changeBeginning("Hola", greeting)
  println(greeting)

  greeting = changeBeginning("Guten tag", greeting)
  println(greeting)

}
