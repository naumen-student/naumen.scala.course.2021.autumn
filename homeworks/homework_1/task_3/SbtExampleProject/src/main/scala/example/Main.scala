package example

object Main extends App {
  def cross[T1, T2](a:Array[T1], b:Array[T2]):Array[(T1, T2)] = {
    for (bElem <- b; aElem <- a) yield (aElem, bElem)
  }

  val hellos = Array("Hello", "Hola", "Guten Tag")

  val myName = "Sergei Lugovykh"
  val names = Array(myName, myName.reverse)

  def getGreeting(hello:String, recipient:String, giver:String):String = {
    s"${hello} ${recipient}! This is ${giver}"
  }

  cross(hellos, names)
    .map({ case (hello, name) => getGreeting(hello, "Scala", name) })
    .foreach(println)
}
