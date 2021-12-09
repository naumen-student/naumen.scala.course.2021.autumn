import scala.util.matching.Regex
import scala.util.{Failure, Success, Try}

object Exercises {
  abstract class Read[+T] {
    def read(s: String): Either[String, T]
  }
  object Read {
    def read[T](s: String)(implicit read: Read[T]): Either[String, T] = {
      read.read(s)
    }
  }

  implicit class RichString(s: String) {
    def read[T](implicit read: Read[T]): Either[String, T] = {
      read.read(s)
    }
  }

  implicit val ReadString: Read[String] = new Read[String] {
    def read(s: String): Either[String, String] = Right(s)
  }

  implicit val ReadInt: Read[Int] = new Read[Int] {
    def read(s: String): Either[String, Int] = {
      val triedRead = Try(s.toInt)
      triedRead match {
        case Success(n) => Right(n)
        case Failure(exc) => Left(s"Couldn't parse to int: $s")
      }
    }
  }

  private val noneRegex: Regex = raw"None".r
  private val someRegex: Regex = raw"Some\((.*)\)".r
  
  implicit def makeReadOption[T : Read] : Read[Option[T]] = new Read[Option[T]] {
    def read(s: String): Either[String, Option[T]] = {
      s match {
        case noneRegex() => Right(None)
        case someRegex(tString) => Read.read[T](tString) match {
          case Right(t) => Right(Some(t))
          case Left(parseErrMsg) => Left(s"Couldn't parse to Option: $parseErrMsg")
        }
        case _ => Left(s"Couldn't parse to Option: $s")
      }
    }
  }
}