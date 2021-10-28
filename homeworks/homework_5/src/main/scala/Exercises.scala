object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal](animals: List[T]) {
    def +[A >: T <: Animal](addend: A): Shelter[A] = Shelter(animals :+ addend)

    def ++[A >: T <: Animal](addend: Shelter[A]): Shelter[A] = Shelter(animals ++ addend.animals)

    def getNames(): List[String] = animals.map(x => x.name)
  }
}

//  trait Food ...
//
//  case object Meat extends Food[Animal] ...
//
//  case object Milk extends Food[Cat] ...
//
//  case object Bread extends Food[Dog] ...

