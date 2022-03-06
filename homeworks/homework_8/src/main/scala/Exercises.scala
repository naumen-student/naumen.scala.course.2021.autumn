import scala.util.Try
import scala.util.matching.Regex

object Exercises {
  val regexSomeStatement = new Regex("""Some\((\S+)\)""")

  trait Read[T] {
    def read(string: String): Either[String, T]
  }

  object Read{
    def read[T](s: String)(implicit reader: Read[T]): Either[String, T] = reader.read(s)
  }

  implicit class ImplicitRead(s: String) {
    def read[T]()(implicit reader: Read[T]): Either[String, T] = reader.read(s)
  }

  implicit object ReadString extends Read[String] {
    def read(string: String): Either[String, String] = Right(string)
  }

  implicit object ReadInt extends Read[Int] {
    def read(string: String): Either[String, Int] = {
      val result = Try(string.toInt).toEither

      result match {
        case Left(exception) => Left(exception.getMessage)
        case Right(number) => Right(number)
      }
    }
  }

  implicit def ReadOption[T: Read]: Read[Option[T]] = {
    case regexSomeStatement(string) => string.read[T] match {
      case Right(value) => Right(Option(value))
      case Left(exception) => Left("Error in Some(...) statement")
    }
    case "None" => Right(None)
    case _ => Left("Error")
  }
}
