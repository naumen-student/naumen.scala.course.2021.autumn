package example

object Main extends App{
  def makeStringAndPrint(inputStr: String): Unit = {
    var greetings = Set("Hello", "Hola", "Guten tag");
    for (greet <- greetings){
      print(s"$greet Scala! This is $inputStr\n")
    }
  }

  var name = "Daniel Evdokimov"
  makeStringAndPrint(name)
  makeStringAndPrint(name.reverse)
}
