object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](animalsList: List[T])
  {
    def +[U >: T <: Animal](animal: U): Shelter[U] = Shelter[U](animalsList :+ animal)
    def ++[U >: T <: Animal](shelter: Shelter[U]): Shelter[U] = Shelter[U](animalsList ++ shelter.animalsList)
    def getNames: Seq[String] = animalsList.map(animal => animal.name)
    def feed[U >: T <: Animal](food: Food[U]): Seq[String] = animalsList.map(animal => food.feed(animal))
  }



  trait Food[-T <: Animal] {
    val foodName: String
    def feed(animal: T) = s"${animal.name} eats $foodName"
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
