import scala.util.Try
import scala.util.matching.Regex

object Exercises {

  val regex = new Regex("^Some\\((.*)\\)$")

  trait Reader[T] {
    def read(string: String): Either[String, T]
  }

  object Read {
    def read[T](string: String)(implicit read: Reader[T]): Either[String, T] = read.read(string)
  }

  implicit class ReadImplicit(string: String) {
    def read[T]()(implicit read: Reader[T]): Either[String, T] = read.read(string)
  }

  implicit val stringReader: Reader[String] = (string: String) => Right(string)

  implicit val intReader: Reader[Int] = (string: String) => {
    if (Try(string.toInt).toOption.isEmpty)
      Left("Error")
    else
      Right(string.toInt)
  }

  implicit def readOption[T: Reader]: Reader[Option[T]] = {
    case "None" => Right(None)
    case string => regex.findFirstMatchIn(string) match {
      case None => Left("Error")
      case Some(matched) => matched.group(1).read[T] match {
        case Right(value) => Right(Some(value))
        case _ => Left("Error")
      }
    }
  }
}
