object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {

    def +[K >:T <: Animal](animal: K):Shelter[K] = Shelter(animals :+ animal)

    def ++[K >:T <: Animal](shelter: Shelter[K]):Shelter[K] = Shelter(List.concat(shelter.animals,animals)

    def getNames:List[String] = animals.map(animal => {animal.name})

    def feed[K>:T <:Animal](food: Food[K]): List[String] = animals.map(animal => food.feed(animal))
  }

  trait Food[-T <: Animal] {
    val food: String
    def feed(animal: T) = s"${animal.name} eats $food"
  }

  case object Meat extends Food[Animal] {
    override val food: String = "meat"
  }

  case object Milk extends Food[Animal] {
    override val food: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val food: String = "bread"
  }
}