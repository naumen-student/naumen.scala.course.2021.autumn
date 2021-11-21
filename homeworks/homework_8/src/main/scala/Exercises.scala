import scala.util.Try
import scala.util.matching.Regex

object Exercises {

  trait Read[T] {
    def read(string: String): Either[String, T]
  }

  object Read {
    def read[T](s: String)(implicit read: Read[T]): Either[String, T] = read.read(s)
  }

  implicit class ImplicitRead(s: String) {
    def read[T]()(implicit read: Read[T]): Either[String, T] = read.read(s)
  }

  implicit object ReadableString extends Read[String] {
    def read(string: String): Either[String, String] = Right(string)
  }

  implicit object ReadableInt extends Read[Int] {
    def read(string: String): Either[String, Int] = Try(string.toInt).toEither match {
      case Right(number) => Right(number)
      case Left(exception) => Left(exception.getMessage)
    }
  }

  val matchSome = new Regex("""Some\((\S+)\)""")

  implicit def ReadOption[T: Read]: Read[Option[T]] = {
    case matchSome(string) => string.read[T] match {
      case Right(value) => Right(Option(value))
      case _ => Left("Error")
    }
    case "None" => Right(None)
    case _ => Left("Error")
  }
}