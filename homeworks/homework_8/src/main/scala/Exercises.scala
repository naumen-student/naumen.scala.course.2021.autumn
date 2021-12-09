import scala.util.Try
import scala.util.matching.Regex

object Exercises {

  val regex = new Regex("""Some\((\S+)\)""")

  trait Reader[T] {
    def read(string: String): Either[String, T]
  }

  object Read {
    def read[T](string: String)(implicit read: Reader[T]): Either[String, T] = {
      read.read(string)
    }
  }

  implicit class ImplicitRead(string: String) {
    def read[T]()(implicit read: Reader[T]): Either[String, T] = read.read(string)
  }

  implicit val ReadString: Reader[String] = (string: String) => Right(string)
  implicit val ReadInt: Reader[Int] =  Read[Int] = n =>
    Try(n.toInt).toOption match {
      case Some(n) => Right(n)
      case None => Left("Error")
    }

  implicit def ReadOption[T: Reader]: Reader[Option[T]] = {
    case "None" => Right(None)
    case regex(s) => Read.read[T](s) match {
      case Right(x) => Right(Some(x))
      case Left(_) => Left("Error")
    }
    case _ => Left("Error")
  }
}