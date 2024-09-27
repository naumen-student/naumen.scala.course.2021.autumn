package task

object Main extends App {
  def print_template(greeting: String, name: String): Unit = {
    println(s"$greeting Scala! This is $name")
  }

  val name = "Max Ratkov"
  print_template("Hello", name)
  print_template("Привет", name)
  print_template("Hello", name.reverse)
  print_template("Привет", name.reverse)
}
