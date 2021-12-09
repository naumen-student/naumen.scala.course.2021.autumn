import scala.util.{Failure, Success, Try}
import scala.util.matching.Regex

object Exercises {
  val someRegex: Regex = """Some\((.*)\)""".r

  trait Readable[T] {
    def read(value: String): Either[String, T]
  }

  object Read {
    def read[T](value: String)(implicit readable: Readable[T]): Either[String, T] = readable.read(value)
  }

  implicit class Read(value: String) {
    def read[T]()(implicit readable: Readable[T]): Either[String, T] = readable.read(value)
  }

  implicit val stringReadable: Readable[String] = (value: String) => Right(value)

  implicit val intReadable: Readable[Int] = (value: String) => {
    Try(value.toInt) match {
      case Success(s) => Right(s)
      case Failure(exception) => Left("Error")
    }
  }

  implicit def optionReadable[T: Readable]: Readable[Option[T]] = {
    case "None" => Right(None)
    case someRegex(str) => str.read[T] match {
      case Right(t) => Right(Some(t))
      case Left(error) => Left("Error")
    }
    case _ => Left("Error")
  }
}
