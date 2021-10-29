object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](animals: List[T]) {

    def +[T1 >: T <: Animal](animal: T1): Shelter[T1] = {
      Shelter(animals :+ animal)
    }

    def ++[T1 >: T <: Animal](other: Shelter[T1]): Shelter[T1] = {
      Shelter[T1](animals ++ other.animals)
    }

    def getNames() : List[String] = animals.map(_.name)

    def feed[T1 >: T <: Animal](food: Food[T1]): List[String] = {
      animals.map(food.feed(_))
    }
  }



  trait Food[T <: Animal] {

    val meal : String

    def feed(animal: T): String = {
      s"${animal.name} eats ${meal}"
    }
  }

  case object Meat extends Food[Animal] {
    override val meal: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override val meal: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override val meal: String = "bread"
  }
}
