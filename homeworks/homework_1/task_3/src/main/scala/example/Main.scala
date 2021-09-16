object Main extends App {
  var name = "Katya Rudenok"

  def hello(word: Array[String] = Array("Hello", "Aloha", "Shalom"), y: String = name): Unit = {

    for ( x <- word ) {
      println( x + " Scala! This is " + y)
    }

    for ( x <- word ) {
      println( x + " Scala! This is " + y.reverse)
    }
  }

  hello()
}
