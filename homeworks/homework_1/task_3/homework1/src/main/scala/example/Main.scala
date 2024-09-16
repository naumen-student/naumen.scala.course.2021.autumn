package example


object Main extends App {
  def batch_print(name: String, hello_words: Array[String]): Unit = {
    for (word <- hello_words) {
      println(s"$word Scala! This is $name")
    }
  }

  var hello_words = Array("Hello", "Hi", "Hola")
  var name = "Ann"

  batch_print(name, hello_words)
  name = name.reverse
  batch_print(name, hello_words)

}
