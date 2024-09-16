package example

object Main extends App {

  var usrName: String = "Yegor Petrov"
  val listOfNames = List("Hola", "Hello", "Aloha", "Guten Tag", "Bonjour", "Hey")

  print(s"Hello Scala! This is $usrName \n")

  def grtMsg(greetings: String): Unit = {
    print(greetings + " " + usrName + "\n")
  }

  listOfNames.foreach(greeting => grtMsg(greeting))
  usrName = usrName.reverse

  listOfNames.foreach(greeting => grtMsg(greeting))

}
