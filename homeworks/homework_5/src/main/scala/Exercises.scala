object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {
    def +[A >: T <: Animal](animal: A): Shelter[A] = Shelter(animals :+ animal)
    def ++[A >: T <: Animal](shelter: Shelter[A]): Shelter[A] = Shelter(animals ++ shelter.animals)
    def getNames : List[String] = animals.map(e => e.name)
    def feed(food: Food[T]): List[String] = animals.map(e => food.feed(e))
  }

  trait Food[-T <: Animal] {
    val foodType: String
    def feed(animal: T): String = s"${animal.name} eats $foodType"
  }

  case object Meat extends Food[Animal] {
    override val foodType = "meat"
  }

  case object Milk extends Food[Cat] {
    override val foodType = "milk"
  }

  case object Bread extends Food[Dog] {
    override val foodType = "bread"
  }
}
