object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {
    def +[B >:T <: Animal](animal: B):Shelter[B] = {
      Shelter(animals :+ animal)
    }
    def ++[B >:T <: Animal](shelter: Shelter[B]):Shelter[B] = {
      Shelter(List.concat(
        shelter.animals, animals
      ))
    }
    def getNames:List[String] = {
      animals.map(animal => {animal.name})
    }

    def feed[B>:T <:Animal](food: Food[B]): List[String] = {
      animals.map(animal => food.feed(animal))
    }
  }

  trait Food[T<: Animal] {
    val food: String
    def feed[B >:T <: Animal](animal: T): String = {
      s"${animal.name} eats $food"
    }
  }

  case object Meat extends Food[Animal]  {
    override val food: String = "meat"
  }

  case object Milk extends Food[Animal]  {
    override val food: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val food: String = "bread"
  }
}
