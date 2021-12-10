import scala.util.Try
import scala.util.matching.Regex


object Exercises {

  trait Read[T] {
    def read(text: String): Either[String, T]
  }

  object Read {
    def read[T](text: String)(implicit r: Read[T]): Either[String, T] = r.read(text)
  }

  implicit class ReadOp(text: String) {
    def read[T]()(implicit r: Read[T]): Either[String, T] = r.read(text)
  }

  implicit val ReadString: Read[String] = (str: String) => Right(str)

  implicit val ReadInt: Read[Int] = (str: String) => Try(str.toInt).toOption match {
    case Some(x) => Right(x)
    case None => Left("can't parse int")
  }

  val regexp: Regex = """Some\((.+?)\)""".r

  implicit def ReadOption[T: Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case regexp(x) => x.read[T].map(Some(_))
    case _ => Left("error")
  }
}