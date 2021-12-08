object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {
    def +[Q >: T <: Animal](newAnimal: Q): Shelter[Q] = {
      Shelter(animals ++ List(newAnimal))
    }

    def ++[Q >: T <: Animal](otherShelter: Shelter[Q]): Shelter[Q] = {
      Shelter(animals ++ otherShelter.animals)
    }

    def getNames: List[String] = {
      animals.map(_.name)
    }

    def feed[Q >: T <: Animal](food: Food[T]): List[String] = {
      animals.map(animal => food.feed(animal))
    }
  }


  trait Food[-T <: Animal] {
    def feed(animal: T): String
  }

  case object Meat extends Food[Animal] {
    override def feed(animal: Animal): String = {
      animal.name + " eats meat"
    }
  }

  case object Milk extends Food[Cat] {
    override def feed(animal: Cat): String = {
      animal.name + " eats milk"
    }
  }

  case object Bread extends Food[Dog] {
    override def feed(animal: Dog): String = {
      animal.name + " eats bread"
    }
  }
}