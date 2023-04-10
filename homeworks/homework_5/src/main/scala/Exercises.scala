object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+A <: Animal] (listAnimals: List[A]) {
    def +[T >: A <: Animal](animal: T): Shelter[T] = {
      Shelter(
        listAnimals ::: List(animal)
      )
    }

    def ++[T >: A <: Animal](animals: Shelter[T]): Shelter[T] = {
      Shelter(List.concat(
        listAnimals,
        animals.listAnimals)
      )
    }

    def getNames: List[String] = {
      listAnimals.map(animal => {
        animal.name
      })
    }

    def feed[T >: A <: Animal] (food: Food[T]): List[String] = {
      listAnimals.map(animal => {
        food.feed(animal)
      })
    }
  }

  object FoodValue extends Enumeration {
    val Milk = "milk"
    val Meat = "meat"
    val Bread = "bread"
  }

  trait Food[-A <: Animal] {
    val food: String

    def feed(animal: A): String = {
      val name = animal.name
      s"$name eats $food"
    }
  }

  case object Meat extends Food[Animal] {
    override val food: String = {
      FoodValue.Meat
    }
  }

  case object Milk extends Food[Cat] {
    override val food: String = {
      FoodValue.Milk
    }
  }

  case object Bread extends Food[Dog] {
    override val food: String = {
      FoodValue.Bread
    }
  }
}
