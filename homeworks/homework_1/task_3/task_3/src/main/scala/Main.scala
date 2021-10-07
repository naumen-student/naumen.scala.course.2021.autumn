object Main extends App {
  val name : String = "Alexander Lavrentiev";

  val defaulHello : String = "Hello";
  val guttenHello : String = "Guten tag";
  val holaHello : String = "Hola";
  val baseHelloString : String = "Scala! This is";

  def hello(helloString : String, contentString: String, name : String) : String = {
    return s"$helloString $contentString $name"
  }

  println(hello(defaulHello, baseHelloString, name));
  println(hello(guttenHello, baseHelloString, name));
  println(hello(holaHello, baseHelloString, name));

  println(hello(defaulHello, baseHelloString, name.reverse));
  println(hello(guttenHello, baseHelloString, name.reverse));
  println(hello(holaHello, baseHelloString, name.reverse));

}
