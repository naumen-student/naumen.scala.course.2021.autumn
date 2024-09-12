object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](value: List[T]) {
    def +[P >: T <: Animal](newAnimal: P): Shelter[P] = {
      Shelter(value :+ newAnimal)
    }
    def ++[V >: T <: Animal](otherShelter: Shelter[V]): Shelter[V] = {
      Shelter(value ++ otherShelter.value)
    }
    def getNames: List[String] = value.map(_.name)
    def feed[N >: T <: Animal](food: Food[N]): List[String] = value.map(animal => s"${animal.name} eats ${food.name}")
  }



  trait Food[-T <: Animal] {
    def name: String
    def feed(animal: T): String = s"${animal.name} eats ${name}"
  }

  case object Meat extends Food[Animal] {
    override def name: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override def name: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override def name: String = "bread"
  }
}
