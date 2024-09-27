object Main extends App {
  def printModifiedHelloScala(word: String, name: String): Unit = {
    println(word + " Scala! This is " + name)
  }

  var words = Array("Hello", "Hi", "Guten tag")
  val name = "Andrew Gomzyakov"
  val reversedName = name.reverse
  for (
    word <- words
  ){
    printModifiedHelloScala(word, name);
    printModifiedHelloScala(word, reversedName);
  }
}