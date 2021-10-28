object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[T <: Animal](animals: List[T]) {
    def feed(food: Food[T]): List[String] = {
      settlersAnimals.map(x => food.feed(x))
    }

    val settlersAnimals = animals

    def +[B >: T <: Animal](animal: B) = {
      Shelter(settlersAnimals :+ animal)
    }

    def ++[B <: Animal](shelter: Shelter[B]) = {
      Shelter(settlersAnimals ++ shelter.settlersAnimals)
    }

    def getNames(): List[String] = {
      settlersAnimals.map(x => x.name)
    }
  }


  trait Food[-T] {
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
