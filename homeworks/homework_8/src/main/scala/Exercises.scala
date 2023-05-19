import scala.util.Try
import scala.util.matching.Regex
object Exercises {
  trait Read[T] {
    def read (str: String): Either[String, T]
  }

  object Read {
    def read[T] (str: String) (
                implicit read: Read[T]
    ): Either[String, T] = {
      read.read(str)
    }
  }

  implicit class ReadOps (str: String) {
    def read[T] () (implicit read: Read[T]): Either[String, T] = read.read(str)
  }

  implicit val stringRead: Read[String] = (str: String) => Right(str)

  implicit val intRead: Read[Int] = (str: String) => Try(str.toInt).toOption match {
    case None => Left("parse fail")
    case Some(x) => Right(x)
  }

  val optionRe = new Regex("^Some\\((.*)\\)$")

  implicit def optionRead[T : Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case str => optionRe.findFirstMatchIn(str) match {
      case None => Left("invalid option")
      case Some(x) => x.group(1).read[T] match {
        case Right(value) => Right(Some(value))
        case _ => Left("some error")
      }
    }
  }
}
