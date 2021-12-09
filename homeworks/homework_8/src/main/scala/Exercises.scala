import scala.util.matching.Regex
import scala.util.{Failure, Success, Try}

object Exercises {
  trait Read[+T] { // в прошедшем времени
    def read(s: String): Either[String, T]
  }
  object Read {
    def read[T](s: String)(implicit tIsRead: Read[T]): Either[String, T] = {
      tIsRead.read(s)
    }

    implicit val StringIsRead: Read[String] = Right(_)

    implicit val IntIsRead: Read[Int] = { s =>
      Try(s.toInt) match {
        case Success(n) => Right(n)
        case Failure(exc) => Left(s"Couldn't parse to int")
      }
    }

    private val noneRegex: Regex = raw"None".r
    private val someRegex: Regex = raw"Some\((.*)\)".r

    implicit def makeOptionIsRead[T : Read] : Read[Option[T]] = { // сильно неявный синтаксис, особенно если с partial function
      case noneRegex() => Right(None)
      case someRegex(tString) => Read.read[T](tString) match {
        case Right(t) => Right(Some(t))
        case Left(parseErrMsg) => Left(s"Couldn't parse to Option: $parseErrMsg")
      }
      case _ => Left(s"Couldn't parse to Option")
    }
  }

  implicit class RichReadString(s: String) {
    def read[T](implicit tIsRead: Read[T]): Either[String, T] = {
      tIsRead.read(s)
    }
  }
}