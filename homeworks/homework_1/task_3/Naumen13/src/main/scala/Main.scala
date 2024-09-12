object Main extends App{
  sealed abstract class Greeting(val strValue: String)
  object Greeting{
    case object Hello extends Greeting("Hello")
    case object Hola extends Greeting("Hola")
    case object GutenTag extends Greeting("Guten Tag")
  }

  val name = "Natalia Pervushina"
  val nameReversed = name.reverse

  def greeting(helloWord: Greeting, name: String): String = s"${helloWord.strValue} Scala! This is $name"

  def greetingWithName = greeting(_, name)

  def greetingWithNameReversed = greeting(_, nameReversed)

  println(greetingWithName(Greeting.Hello))
  println(greetingWithName(Greeting.Hola))
  println(greetingWithName(Greeting.GutenTag))

  println(greetingWithNameReversed(Greeting.Hello))
  println(greetingWithNameReversed(Greeting.Hola))
  println(greetingWithNameReversed(Greeting.GutenTag))
}
