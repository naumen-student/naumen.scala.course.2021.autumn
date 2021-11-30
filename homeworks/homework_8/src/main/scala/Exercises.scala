import scala.util.Try
object Exercises {
  val reg = """Some\((\S+)\)""".r
  trait Read[T] {
    def read (string: String): Either[String, T]
  }

  object Read {
    def read[T] (string: String) (implicit reader: Read[T]): Either[String, T] = {
      reader.read(string)
    }

    implicit val readInt: Read[Int] = (string: String) => Try(string.toInt).toOption match {
      case Some(x) => Right(x)
      case None => Left("Oops! Can not read")
    }

    implicit val readString: Read[String] = (string: String) => Right(string)
  }

  implicit class ReadImplicit (string: String) {
    implicit def read[T] () (implicit reader: Read[T]): Either[String, T] = reader.read(string)
  }

  implicit def optionRead[T : Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case string: String => reg.findFirstMatchIn(string) match {
      case Some(x) => x.group(1).read[T] match {
        case Right(x) => Right(Some(x))
        case _ => Left("Oops! Can not read")
      }
      case None => Left("Oops! Can not read")
    }
  }
}
