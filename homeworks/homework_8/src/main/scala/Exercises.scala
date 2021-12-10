import scala.util.Try
import scala.util.matching.Regex

object Exercises {

  trait Read[T] {
    def read(value: String): Either[String, T]
  }

  object Read{
    def read[A](a: String)(implicit read: Read[A]): Either[String, A] = read.read(a)
  }

  implicit class ReadOps(a: String){
    def read[A]()(implicit read: Read[A]): Either[String, A] = read.read(a)
  }

  implicit val StringRead: Read[String] = (a: String) => Right(a)

  implicit val IntRead: Read[Int] = (a: String) => Try(a.toInt).toOption match {
    case Some(x) => Right(x)
    case None => Left("unable to parse")
  }

  val re: Regex = """Some\((\S+?)\)""".r

  implicit def optRead[T: Read]: Read[Option[T]] = {
    case "None" => Right(None)
    case re(value) => value.read[T] match {
      case Right(some) => Right(Some(some))
      case Left(_) => Left("Failure")
    }
    case _ => Left("Failure")
  }}
