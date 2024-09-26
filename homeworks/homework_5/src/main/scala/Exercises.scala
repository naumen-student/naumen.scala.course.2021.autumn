object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter[+T <: Animal](animals: List[T]) {
    def +[TRes >: T <: Animal](otherAnimal: TRes): Shelter[TRes] = {
      Shelter(otherAnimal :: animals)
    }

    def ++[TRes >: T <: Animal](otherShelter: Shelter[TRes]): Shelter[TRes] = {
      if (animals.length <= otherShelter.animals.length) {
        Shelter(animals ::: otherShelter.animals)
      } else {
        Shelter(otherShelter.animals ::: animals)
      }
    }

    def getNames: List[String] = animals.map(_.name)

    def feed(food: Food[T]): List[String] = {
      animals.map(food.feed)
    }
  }



  trait Food[-ForT <: Animal] {
    val foodName: String

    def feed(animal: ForT): String = {
      s"${animal.name} eats ${foodName}"
    }
  }

  case object Meat extends Food[Animal] {
    override val foodName: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val foodName: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val foodName: String = "bread"
  }
}
