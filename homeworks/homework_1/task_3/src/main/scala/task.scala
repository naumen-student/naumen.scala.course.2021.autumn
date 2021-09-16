object Main extends App{
  println("Hello Scala! This is Eugene")

  printf("%s Scala! This is Eugene", "Bonjour")

  var greetings = Array("Hello", "Hola", "Bonjour", "Zdarova")

  greetings(0)

  greetings(2)

  greetings.foreach(greeting => printf("%s Scala! This is Eugene", greeting))

  greetings.foreach(greeting => println(s"$greeting Scala! This is Eugene!!!"))

  greetings.foreach(greeting => println(greeting + " Scala! This is " + "Eugene".reverse))

  var myName = "Eugene"

  greetings.foreach(greeting => println(greeting + " Scala! This is " + myName.reverse))
}