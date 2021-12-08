object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](val list: List[T]){
    def +[X >: T <: Animal](other: X):Shelter[X] = new Shelter[X](this.list :+ other)
    def ++[Y >: T <: Animal](other: Shelter[Y]): Shelter[Y] = new Shelter[Y](this.list ::: other.list)
    def getNames: List[String] = this.list.map(_.name)
    def feed[Z >: T <: Animal](meal: Food[Z]): List[String] = this.list.map(meal.feed)
  }



  trait Food[T <: Animal]{
    def food: String
    def feed(animal: T): String = f"${animal.name} eats ${food}"
  }

  case object Meat extends Food[Animal] {
    override def food: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override def food: String = "milk"
  }

  case object Bread extends Food[Dog]{
    override def food: String = "bread"
  }
}
