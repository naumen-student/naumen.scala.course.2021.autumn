object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](input_animals: List[T]) {
    def feed[T1 >: T <: Animal](food: Food[T1]): List[String] = animals.map(animal => food.feed(animal))

    val animals: List[T] = input_animals

    def getNames: List[String] = input_animals.map(animal => animal.name)

    def +[T1 >: T <: Animal](newAnimal: T1): Shelter[T1] = Shelter[T1](animals :+ newAnimal)

    def ++[T2 >: T <: Animal](anotherShelter: Shelter[T2]): Shelter[T2] =
      Shelter[T2](this.animals ++ anotherShelter.animals)
  }

  trait Food[T <: Animal] {
    var typeOfFood: String

    def feed(animal: T): String = f"${animal.name} eats ${typeOfFood}"
  }

  case object Meat extends Food[Animal] {
    override var typeOfFood: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override var typeOfFood: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override var typeOfFood: String = "bread"
  }
}
