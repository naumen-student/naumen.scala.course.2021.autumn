import scala.util.Try
import scala.util.matching.Regex
object Exercises {

  val intError = "incorrect representation"
  val optError = "unable to read"
  val optErrorInReg = "unable to read option"
  val regex = new Regex("""Some\((\S+)\)""")

  trait Read[T] {
    def read (str: String): Either[String, T]
  }

  object Read {
    def read[T](s: String)(implicit read: Read[T]): Either[String, T] = {
      read.read(s)
    }
  }

  implicit class ImplicitRead(str: String) {
    def read[T]()(implicit read: Read[T]): Either[String, T] = read.read(str)
  }

  implicit val ReadString: Read[String] = s => Right(s)
  implicit val ReadInt: Read[Int] = n =>
    Try(n.toInt).toOption match {
      case Some(n) => Right(n)
      case None => Left(intError)
    }

  implicit def ReadOption[T: Read]:Read[Option[T]] = {
    case "None" => Right(None)
    case regex(s) => Read.read[T](s) match {
      case Right(x) => Right(Some(x))
      case Left(_) => Left(optErrorInReg)
    }
    case _ => Left(optError)
  }
}
