object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal


  case class Shelter [+T <: Animal] (list: List[T]) {

    def +[A >: T <: Animal](other: A) : Shelter[A] = Shelter(other +: this.list )

    def ++[B >: T <: Animal](other: Shelter[B]) : Shelter[B] = Shelter(other.list ::: this.list)

    def getNames: List[String] = list.map(_.name)

    def feed[C >: T <: Animal](food: Food[C]): Seq[String] = this.list.map(food.feed)
  }


  trait Food[T <: Animal]{
    val foodType: String
    def feed[T <: Animal](animal: T): String =
      s"${animal.name} eats ${foodType.toLowerCase}"
  }
  case object Meat extends Food[Animal] {
    override val foodType = "meat"
  }

  case object Milk extends Food[Cat] {
    override val foodType = "milk"
  }

  case object Bread extends Food[Dog] {
    override val foodType = "bread"
  }
}
