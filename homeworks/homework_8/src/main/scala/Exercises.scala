import scala.util.Try
object Exercises {

  val regex = """Some\((\S+)\)""".r

  trait Read[T] {
    def read (str: String): Either[String, T]
  }

  implicit class ImplicitRead(string: String) {
    def read[T]()(implicit read: Read[T]): Either[String, T] = read.read(string);
  }

  object Read {
    def read[T](string: String)(implicit read: Read[T]): Either[String, T] = read.read(string)

    implicit object readString extends Read[String] {
      def read(string: String): Either[String, String] = Right(string);
    }

    implicit object readInt extends Read[Int] {
      def read(string: String): Either[String, Int] =
        Try(string.toInt).toOption match {
          case Some(x) => Right(x)
          case None => Left("error")
        }
    }

    implicit def readOption[T: Read]: Read[Option[T]] = {
      case regex(string) => string.read[T] match {
        case Right(value) => Right(Some(value))
        case _ => Left("error")
      }
      case "None" => Right(None)
      case _ => Left("error")
    }
  }
}
