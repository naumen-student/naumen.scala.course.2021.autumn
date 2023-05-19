import scala.util.matching.Regex
object Exercises {
  val LeftString = "Could not handle"

  trait Read[A]{
    def read(a: String): Either[String, A]
  }

  object Read{
    def read[A](a: String)(implicit read: Read[A]): Either[String, A] = read.read(a)
  }

  implicit class ReadOps(a: String){
    def read[A]()(implicit read: Read[A]): Either[String, A] = read.read(a)
  }

  implicit val StringRead: Read[String] = (a: String) => Right(a)

  implicit val IntRead: Read[Int] = (a: String) => {
    if (CheckIfNumber(a)) Right(a.toInt)
    else Left(LeftString)
  }

  val pattern: Regex = """Some\(([\S]+?)\)""".r

  implicit def optRead[T: Read]: Read[Option[T]] = {
    case pattern(value) => value.read[T] match {
      case Right(some) => Right(Some(some))
      case Left(_) => Left(LeftString)
    }
    case a => if (a == "None") Right(None) else Left(LeftString)
  }

  def CheckIfNumber(string: String): Boolean = string forall Character.isDigit
}
