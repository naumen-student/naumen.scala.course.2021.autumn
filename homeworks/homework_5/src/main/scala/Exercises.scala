object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+T <: Animal](animals: List[T]) {
    def +[TAnimal >: T <: Animal](animal: TAnimal): Shelter[TAnimal] = Shelter(animals :+ animal)

    def ++[TAnimal >: T <: Animal](shelter: Shelter[TAnimal]): Shelter[TAnimal] = Shelter(animals ++ shelter.animals)

    def getNames: List[String] = animals.map(animal => animal.name)

    def feed[TAnimal >: T <: Animal](food: Food[TAnimal]): List[String] = animals.map(animal => food.feed(animal))
  }


  trait Food[T <: Animal] {
    val foodType: String

    def feed(animal: T): String = s"${animal.name} eats $foodType"
  }

  case object Meat extends Food[Animal] {
    override val foodType: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val foodType: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val foodType: String = "bread"
  }
}
