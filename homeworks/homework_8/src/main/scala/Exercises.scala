import scala.util.Try

object Exercises {

  trait Read[T] {
    def read (string: String): Either[String, T]
  }

  object Read {
    def read[T](str: String)(implicit read: Read[T]): Either[String, T] = read.read(str)
  }

  implicit class ImplicitRead(str: String) {
    def read[T]()(implicit read: Read[T]): Either[String, T] = read.read(str)
  }

  implicit val ReadString: Read[String] = (str: String) => Right(str)

  implicit val ReadInt: Read[Int] = (str: String) => Try(str.toInt).toOption match {
    case Some(x) => Right(x)
    case None => Left("is not a number")
  }


  val regex = """Some\((\S+)\)""".r

  implicit def optRead[T: Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case str => regex.findFirstMatchIn(str) match {
      case Some(x) => x.group(1).read[T] match {
        case Right(x) => Right(Some(x))
        case _ => Left("error")
      }
      case _ => Left("error")
    }
  }
}
