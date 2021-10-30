object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+T <: Animal](l: List[T]) {
    def +[U >: T <: Animal](a: U): Shelter[U] = Shelter(a :: l)
    def ++[U >: T <: Animal](s: Shelter[U]): Shelter[U] = Shelter(l ::: s.l)
    def getNames: List[String] = l.map(_.name)
    def feed[U >: T <: Animal](f: Food[U]): List[String] = l.map(f.feed)
  }



  trait Food[T <: Animal] {
    protected def foodName: String
    def feed(a: Animal): String =  s"${a.name} eats $foodName"
  }

  case object Meat extends Food[Animal] {
    override protected val foodName: String = "meat"
  }

  case object Milk extends Food[Cat] {
    override protected val foodName: String = "milk"
  }

  case object Bread extends Food[Dog] {
    override protected val foodName: String = "bread"
  }
}
