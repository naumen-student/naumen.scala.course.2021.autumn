object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](val list: List[T]) {
    def ++[G >: T <: Animal](s2: Shelter[G]): Shelter[G] = {
      Shelter(list ++ s2.list)
    }

    def +[G >: T <: Animal](s2: G): Shelter[G] = {
      Shelter(list :+ s2)
    }

    def getNames(): List[String] = list.map(_.name)

    def feed[G >: T <: Animal](food: Food[G]): List[String] = list.map(food.feed)
  }


  trait Food[T <: Animal] {
    val foodName: String
    def feed(animal: T): String = s"${animal.name} eats ${foodName.toLowerCase}"
  }

  case object Meat extends Food[Animal] {
    override val foodName: String = "Meat"
  }

  case object Milk extends Food[Cat] {
    override val foodName: String = "Milk"
  }

  case object Bread extends Food[Dog] {
    override val foodName: String = "Bread"
  }
}
