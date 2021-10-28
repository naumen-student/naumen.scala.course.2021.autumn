import Exercises.{Animal, Cat, Dog}

object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {
    def +[A >: T <: Animal](addend: A): Shelter[A] = Shelter(animals :+ addend)

    def ++[A >: T <: Animal](addend: Shelter[A]): Shelter[A] = Shelter(animals ++ addend.animals)

    def getNames(): List[String] = animals.map(x => x.name)

    def feed(food: Food[T]): List[String] = animals.map(x => food.feed(x))
  }
}

trait Food[-A <: Animal] {
  def feed(animal: A): String
}

case object Meat extends Food[Animal] {
  override def feed(animal: Animal): String = animal.name + " eats meat"
}

case object Milk extends Food[Cat] {
  override def feed(animal: Cat): String = animal.name + " eats milk"
}

case object Bread extends Food[Dog] {
  override def feed(animal: Dog): String = animal.name + " eats bread"
}

