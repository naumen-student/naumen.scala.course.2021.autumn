import scala.util.Try
import scala.util.matching.Regex

object Exercises {

  val regex = new Regex("""Some\((\S+)\)""")

  trait Reader[T] {
    def read(val: String): Either[String, T]
  }

  object Read {
    def read[T](val: String)(implicit read: Reader[T]): Either[String, T] = read.read(val)
  }

  implicit class ImplicitRead(val: String) {
    def read[T]()(implicit read: Reader[T]): Either[String, T] = read.read(val)
  }

  implicit val stringRead: Readable[String] = (val: String) => Right(val)
  implicit val intRead: Reader[Int] = (val: String) =>
  {
    Try(val.toInt) match
    {
      case Success(n) => Right(n)
      case Failure(exception) => Left("Error")
    }
  }

  implicit def optionRead[T: Reader]: Reader[Option[T]] = {
    case "None" => Right(None)
    case regex(s) => Read.read[T](s) match {
      case Right(t) => Right(Some(t))
      case Left(error) => Left("Error")
    }
    case _ => Left("Error")
  }
}