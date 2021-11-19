import scala.util.matching.Regex
import scala.util.Try

object Exercises {
  val Err = "Error"

  trait Read[T]{
    def read(a: String): Either[String, T]
  }

  object Read{
    def read[T](s: String)(implicit read: Read[T]): Either[String, T] = read.read(s)
  }

  implicit class ReadOps(s: String){
    def read[T]()(implicit read: Read[T]): Either[String, T] = read.read(s)
  }

  implicit val StringRead: Read[String] = (s: String) => Right(s)

  implicit val intRead: Read[Int] = (str: String) => Try(str.toInt).toOption match {
    case None => Left(Err)
    case Some(x) => Right(x)
  }

  val somePattern: Regex = """Some\((\S+)\)""".r

  implicit def ReadOption[T: Read]: Read[Option[T]] = {
    case somePattern(value) => value.read[T] match {
      case Right(some) => Right(Some(some))
      case Left(_) => Left(Err)
    }
    case a => if (a == "None") Right(None) else Left(Err)
  }

  def CheckIfNumber(string: String): Boolean = string forall Character.isDigit
}