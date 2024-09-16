object Main extends App {
  val a = "Hello Scala! This is"
  val name = "Denis Myshinskii"
  val b = a.replace("Hello", "Hola")
  val c = b.replace("Hola", "Aloha")
  val name_rev = name.reverse

  def print_sentence (x: Int): Unit = {
    x match {
      case 0 => println(a + ' ' + name);
      case 1 => println(b + ' ' + name);
      case 2 => println(c + ' ' + name);
      case 3 => print(a + ' '+ name_rev + '\n' + b + ' ' + name_rev + '\n' + c + ' ' + name_rev);
    }
  }

  for (i <- 0 to 3){
    print_sentence(i)
  }
}
