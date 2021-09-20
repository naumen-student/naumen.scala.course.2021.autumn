object Main extends App {

  def reverse(s: String): String = {
    if (s.isEmpty) ""
    else reverse(s.tail) + s.head
  }

  val NAME = "Vlad"
  val REVERSE_NAME = reverse(NAME)
  val TEMPLATE = s" Scala! This is $NAME"
  val TEMPLATE_WITH_REVERSE_NAME = s" Scala! This is $REVERSE_NAME"

  val engGreeting = "Hello"
  val gerGreeting = "Guten tag"
  val hunGreeting = "Szia"

  val greetingList = Array(
    engGreeting,
    gerGreeting,
    hunGreeting
  )

  val n = greetingList.length - 1

  for (index <- 0 to n) {
    println(greetingList(index) + TEMPLATE)
  }

  for (index <- 0 to n) {
    println(greetingList(index) + TEMPLATE_WITH_REVERSE_NAME)
  }
}