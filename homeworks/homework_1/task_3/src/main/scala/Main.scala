class Person(yourName: String) {
  val name: String = yourName;
}

object HelloHelper {
  def sayHello(person: Person): Unit = {
    println(s"Hello Scala! This is ${person.name}!");
  }

  def sayHola(person: Person): Unit = {
    println(s"Hola Scala! This is ${person.name}!");
  }

  def sayGutenTag(person: Person): Unit = {
    println(s"Hello Scala! This is ${person.name}");
  }
}

object Main extends App {
  val me = new Person("Artem");
  HelloHelper.sayHello(me);
  HelloHelper.sayHola(me);
  HelloHelper.sayGutenTag(me);

  println

  val reverseMe = new Person(me.name.reverse)
  HelloHelper.sayHello(reverseMe);
  HelloHelper.sayHola(reverseMe);
  HelloHelper.sayGutenTag(reverseMe);
}