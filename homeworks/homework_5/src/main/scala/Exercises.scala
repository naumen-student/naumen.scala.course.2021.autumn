object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](shelter: List[T]) {

    def +[A >: T <: Animal](animal: A): Shelter[A] = Shelter(shelter :+ animal)

    def ++[A >: T <: Animal](animals: Shelter[A]): Shelter[A] = Shelter(shelter ++ animals.shelter)

    def getNames: List[String] = shelter.map(animal => animal.name)

    def feed(food: Food[T]): List[String] = shelter.map(animal => food.feed(animal))
  }



  trait Food[-T <: Animal] {
    def feed(animal: T): String
  }

  case object Meat extends Food[Animal] {
    override def feed(animal: Animal): String = s"${animal.name} eats meat"
  }

  case object Milk extends Food[Cat] {
    override def feed(animal: Cat): String = s"${animal.name} eats milk"
  }

  case object Bread extends Food[Dog] {
    override def feed(animal: Dog): String = s"${animal.name} eats bread"
  }
}
